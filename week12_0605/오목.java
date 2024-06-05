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
        map = new int[21][21]; //1~19까지 모두 탐색하려면 20번째 행렬이 필요하기 때문에 21로 설정
        memo = new int[21][21][4];

        for(int i=1; i<20; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<20; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int j=1; j<20; j++){ // 주의 : 열방향 탐색(왼쪽 열에 있는 바둑알을 먼저 탐색해야함 -> 방향 벡터 생각해보기)
            for(int i=1; i<20; i++){ // 열방향 탐색 후 행방향 탐색
                if(map[i][j] != 0){
                    for(int d=0; d<4; d++){
                        if(memo[i][j][d] == 0 && dfs(i, j, d, map[i][j]) == 5){
                            System.out.print(map[i][j] + "\n" + i + " " + j);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0); // 주의 : 0출력하는 거 꼭 고려하기

    }

    public static int dfs(int x, int y, int d, int color){
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(map[nx][ny] == color){
            return memo[nx][ny][d] = dfs(nx, ny, d, color) + 1;
        }

        return 1;
    }
}

