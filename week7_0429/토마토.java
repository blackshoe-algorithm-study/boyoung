package week7_0429;

import java.io.*;
import java.util.*;

public class 토마토 {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    queue.add(new int[] {i ,j});
                }
            }
        }

        int answer = bfs(N, M);
        System.out.println(answer);
    }

    static int bfs(int N, int M){
        int max = 0;
        while(!queue.isEmpty()){
            int c[] = queue.poll();
            int x = c[0];
            int y = c[1];
            for(int i=0; i<4; i++){
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(map[nx][ny] == 0){
                    map[nx][ny] = map[x][y]+1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(max < map[i][j]){
                    max = map[i][j];
                }
                if(map[i][j] == 0){
                    return -1;
                }
            }
        }

        if(max == 1){
            return 0;
        }

        return max-1;

    }
}
