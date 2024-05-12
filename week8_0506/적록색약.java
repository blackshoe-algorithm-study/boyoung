package week8_0506;

import java.io.*;
import java.util.*;

public class 적록색약 {
    static int N;
    static boolean[][] visited;
    static int normalCount;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        String str;
        map = new char[N][N];

        for(int i=0; i<N; i++){
            str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j);
            }
        }


        for(int i=0; i<N; i++){   
            for(int j=0; j<N; j++){                
                if(!visited[i][j]){
                    normalCount += dfs(i, j);
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]=='G'){
                    map[i][j]='R';
                }
                visited[i][j] = false;
            }
        }

        int count = 0;

        for(int i=0; i<N; i++){   
            for(int j=0; j<N; j++){                
                if(!visited[i][j]){
                    count += dfs(i, j);
                }
            }
        }

        System.out.println(normalCount + " " + count);
    }

    public static int dfs(int x, int y){
        visited[x][y] = true;
        int c = map[x][y];

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if(!visited[nx][ny] && map[nx][ny] == c){
                dfs(nx, ny);
            }
        }

        return 1;
    }
}
