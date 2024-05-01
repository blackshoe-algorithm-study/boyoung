package week7_0501;

import java.io.*;
import java.util.*;

public class 촌수계산 {
    static int[] dist;
    static int[][] graph;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        dist = new int[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1; // 인접행렬
        }

        System.out.println(bfs(start, end) == 0 ? -1:bfs(start, end));
    }
    static int bfs(int start, int end){
        Queue<Integer> q =  new LinkedList<>();
        q.add(start);
        //그래프에서 찾은 인접행렬들을 queue에 넣고 dist갱신
        
        while(!q.isEmpty()){
            int c = q.poll();

            if(c==end){
                return dist[end];
            }

            for(int i=0; i<n+1; i++){
                if(graph[c][i]==1 && dist[i]==0){ // 인접노드이면서 미방문
                    q.add(i);
                    dist[i] = dist[c] + 1;
                }
            }
        }

        return dist[end];

    }
}
