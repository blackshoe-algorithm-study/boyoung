package week12_0603;

import java.io.*;
import java.util.*;

public class 미세먼지_안녕 {
    static int R, C, T;
    static int[][] map;
    static Queue<Dust> dusts;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cleaner = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == -1 && cleaner == -1){ // 공기 청정기 위치 저장
                    cleaner = i; // 몇번째 행부터 cleaner가 있는지
                }
            }
        }

        for(int i=0; i<T; i++){
            checkDust();
            calculate();
            operate();
        }

        int answer = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] != -1){
                    answer += map[i][j];
                }
            }
        }

        System.out.println(answer);

    }

    public static void checkDust(){
        dusts = new LinkedList<>();

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == -1 || map[i][j] == 0) continue;
                dusts.add(new Dust(i, j, map[i][j]));
            }
        }
    }

    public static void calculate(){
        while(!dusts.isEmpty()){
            Dust now = dusts.poll();
            if(now.w < 5) continue;
            int count = 0;

            for(int k=0; k<4; k++){
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if(nx<0 || ny<0 || nx>=R|| ny>=C) continue; //경계
                if(map[nx][ny] == -1) continue;//청정기

                map[nx][ny] += (now.w/5);
                count++;
            }

            map[now.x][now.y] -= (now.w/5)*count;
        }
    }

    public static void operate(){
        //------------------반시계방향
        //아래로 당기기
        for(int i=cleaner-1; i>0; i--){
            map[i][0] = map[i-1][0];
        }
        //왼쪽으로 당기기
        for(int i=0; i<C-1; i++){
            map[0][i] = map[0][i+1];
        }
        //위로 당기기
        for(int i=0; i<cleaner; i++){
            map[i][C-1] = map[i+1][C-1];
        }
        //오른쪽으로 당기기
        for(int i=C-1; i>1; i--){
            map[cleaner][i] = map[cleaner][i-1];
        }
        map[cleaner][1] = 0;

        //-----------------시계방향
        //위로 당기기
        for(int i=cleaner+2; i<R-1; i++){
            map[i][0] = map[i+1][0];
        }

        //왼쪽으로 당기기
        for(int i=0; i<C-1; i++){
            map[R-1][i] = map[R-1][i+1];
        }

        //아래로 당기기
        for(int i=R-1; i>cleaner+1; i--){
            map[i][C-1] = map[i-1][C-1];
        }

        //오른쪽으로 당기기
        for(int i=C-1; i>1; i--){
            map[cleaner+1][i] = map[cleaner+1][i-1];
        }
        map[cleaner+1][1] = 0;
    }
}

class Dust{
    int x, y, w;

    public Dust(int x, int y, int w){
        this.x = x;
        this.y = y;
        this.w = w;
    }
}