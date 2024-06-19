package week13_0619;

import java.io.*;
import java.util.*;

public class 파티 {
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reverse_graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        reverse_graph = new ArrayList[N+1];

        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
            reverse_graph[i] = new ArrayList<>();
        }

        //양방향 그래프로 처리 안해주는 이유 : 간선의 가중치가 달라지기 때문
        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, w)); 
            reverse_graph[end].add(new Node(start, w));
        }

        int[] dist_result1 = dijkstra(graph);
        int[] dist_result2 = dijkstra(reverse_graph);

        int max = Integer.MIN_VALUE;

        for(int i=0; i<N+1; i++){
            max = Math.max(max, dist_result1[i] + dist_result2[i]);
        }

        System.out.println(max);

    }

    public static int[] dijkstra(ArrayList<Node>[] graph){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(X, 0));
        dist[X] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int c = now.v;

            if(visited[c]) continue;
            visited[c] = true;
            for(Node next : graph[c]){
                if(dist[next.v] > dist[c]+ next.w){
                    dist[next.v] = dist[c]+ next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }

        }

        return dist;
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
