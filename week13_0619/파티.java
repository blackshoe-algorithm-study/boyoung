package week13_0619;

import java.io.*;
import java.util.*;

public class 파티 {
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];

        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, w));
        }

        dijkstra();
        int max = Integer.MIN_VALUE;

        for(int i=1; i<N+1; i++){
            if(dist[i] > dist[i+1]){
                max = dist[i];
            }
        }

        System.out.println(max);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        dist[X] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int c = now.v;

            if(visited[c]) continue;
            visited[c] = true;
            for(Node next : graph[c]){
                if(dist[next.w] > dist[c]+ next.w){
                    dist[next.w] = dist[c]+ next.w;
                    pq.add(new Node(next.v, dist[next.w]));
                }
            }

        }
    }

}

class Node implements Comparable<Node>{
    int v, w;
    public Node(int v, int w){
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node other){
        return Integer.compare(this.w, other.w);
    }
}
