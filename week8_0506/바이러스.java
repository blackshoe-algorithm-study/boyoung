package week8_0506;

import java.io.*;
import java.util.*;

public class 바이러스 {
    static int n, m;
    static boolean[] visited;
    static int[][] graph;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        StringTokenizer st;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(1);

        System.out.println(count-1);
    }

    public static void dfs(int start){
        visited[start] = true;
        count++;

        for(int i=1; i<n+1; i++){
            if(graph[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
        
    }
}
