package week12_0603;

import java.io.*;
import java.util.*;

public class 뱀 {
    static int N, K, L;
    static int[][] map;
    static HashMap<Integer, String> hashmap;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; // 북(0) 동(1) 남(2) 서(3)
    static int time = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        //map에 사과 위치 설정
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        //뱀 방향 전환 저장
        hashmap = new HashMap<>(); // Character형 안됌
        L = Integer.parseInt(br.readLine());

        for(int i=0; i<L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            hashmap.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        solution();

        System.out.println(time);
    }

    public static void solution(){
        Queue<Location> snake = new LinkedList<>();
        Location location = new Location(1, 1); // 시작점 설정
        snake.add(location);
        int d = 1;
        
        while(true){
            int nx = location.x + dx[d];
            int ny = location.y + dy[d];
            time++;
            
            //벽에 부딪히는 경우 종료
            if(nx < 1 || ny < 1 || nx >= N+1 || ny >= N+1) return;

            //몸에 부딪히는 경우 종료
            for(Location l : snake){
                if(nx == l.x && ny == l.y) return;
            }

            // 다음으로 이동하는 경우

            //사과 먹기
            if(map[nx][ny] == 1){ //사과 먹는 경우
                map[nx][ny] = 0;
                snake.add(new Location(nx, ny));
            }else{ //사과 없는 경우
                snake.add(new Location(nx, ny));
                snake.poll();
            }

            //방향전환 고려
            if(hashmap.containsKey(time)){
                if(hashmap.get(time).equals("D")){
                    d += 1;
                    if(d > 3) d = 0;
                }else{
                    d -= 1;
                    if(d < 0) d = 3;
                }
                hashmap.remove(time);
            }

            location.x = nx;
            location.y = ny;

        }
    }


}

class Location{
    int x, y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
