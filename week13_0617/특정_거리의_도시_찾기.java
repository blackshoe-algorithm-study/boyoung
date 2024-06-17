package week13_0617;

import java.io.*;
import java.util.*;

public class 특정_거리의_도시_찾기 {
    static int N, M, K, X;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];

        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        dijkstra(X);

        int count = 0;

        for(int i=1; i<dist.length; i++){
            if(dist[i] == K){
                count++;
                System.out.println(i);
            }
        }

        if(count == 0){
            System.out.println(-1);
        }

    }

    public static void dijkstra(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            int c = q.poll();
            if(visited[c]) continue;
            visited[c] = true;
            for(int next : graph[c]){
                if(dist[next] != INF){
                    dist[next] = Math.min(dist[next], dist[c] + 1);
                }else{
                    dist[next] = dist[c] + 1;
                }
                q.add(next);
            }
        }
    }
}
