package week8_0506;

import java.io.*;
import java.util.*;

public class 안전_영역 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] map;
    static int n, minH = 0, maxH = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        int areaCount = 0;
        int maxAreaCount = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(map[i][j], minH);
                maxH = Math.max(map[i][j], maxH);
            }
        }

        for(int i=minH; i<=maxH; i++){
            visited = new boolean[n][n];
            areaCount=0;
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(!visited[j][k] && map[j][k] > i){
                        areaCount += dfs(j, k, i);
                    }
                }
            }

            maxAreaCount = Math.max(areaCount, maxAreaCount);
        }

        System.out.println(maxAreaCount);

    }
    public static int dfs(int x, int y, int height){
        visited[x][y] = true;
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=n)continue;

            if(!visited[nx][ny] && map[nx][ny] > height){
                dfs(nx, ny, height);
            }
        }
        return 1;
    }
}

