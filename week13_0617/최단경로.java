package week13_0617;

import java.io.*;
import java.util.*;

public class 최단경로{
    static int V, E, K;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        dist = new int[V+1];
        visited = new boolean[V+1];

        for(int i=1; i<V+1; i++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Node node = new Node(v, w);
            graph[u].add(node);
        }

        dijkstra();

        for(int i=1; i<V+1; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }
    public static void dijkstra(){
        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        dist[1] = 0;

        while(!q.isEmpty()){
            int c = q.poll();
            if(visited[c]) continue;
            visited[c] = true;
            for(Node next : graph[c]){
                if(dist[next.v] != INF){
                    dist[next.v] = Math.min(dist[next.v], dist[c] + next.w);
                    q.add(next.v);
                }
                else{
                    dist[next.v] = dist[c] + next.w;
                    q.add(next.v);
                }
            }

        }

    }
}

class Node{
    int v;
    int w;

    public Node(int v, int w){
        this.v = v;
        this.w = w;
    }
}