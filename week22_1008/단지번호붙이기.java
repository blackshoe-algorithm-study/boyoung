package week22_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기 {
    static int N;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int num=0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j]==1){
                    int result = dfs(i, j, 0);
                    num++;
                    list.add(result);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        
        for(int e:list){
            System.out.println(e);
        }
        
    }

    public static int dfs(int x, int y, int count){
        visited[x][y] = true;
        count++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if(!visited[nx][ny] && map[nx][ny]==1){
                count = dfs(nx, ny, count++);
            }
        }

        return count;
    }
}
