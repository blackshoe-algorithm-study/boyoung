package week12_0605;

import java.io.*;
import java.util.*;

public class 오목 {
    static int[] dx = {1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1};
    static int[][] map;
    static int[][][] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        map = new int[21][21];
        memo = new int[21][21][4];

        for(int i=1; i<20; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<20; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<20; i++){
            for(int j=1; j<20; j++){
                if(map[i][j] != 0){
                    for(int d=0; d<4; d++){
                        if(memo[i][j][d] == 0 && dfs(i, j, d, map[i][j]) == 5){
                            sb.append(map[i][j]).append("\n").append(i + " " + j);
                        }
                    }
                }
            }
        }

        System.out.println(sb);

    }

    public static int dfs(int x, int y, int d, int color){
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(nx<1 || nx>19 || ny<1 || ny>19 || map[nx][ny] != color) return 1;

        if(map[nx][ny] == color){
            return memo[nx][ny][d] = dfs(nx, ny, d, color) + 1;
        }

        return 1;
    }
}

