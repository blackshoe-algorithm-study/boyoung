package week13_0617;

import java.io.*;
import java.util.*;

public class 최소비용_구하기 {
    static int N, M, S, E;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList[N+1];

        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, w));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        dist = new int[N+1];

        Arrays.fill(dist, INF);

        dijkstra();

        System.out.println(dist[E]);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S, 0));
        dist[S] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int c = current.v;

            if (visited[c]) continue;
            visited[c] = true;

            for (Node next : graph[c]) {
                if(dist[next.v] != INF){
                    dist[next.v] = Math.min(dist[next.v], dist[c] + next.w);
                }else{
                    dist[next.v] = dist[c] + next.w;
                }
                next.w = dist[next.v];
                pq.add(next);
            }
        }
    }
}

class Node implements Comparable<Node>{
    int v;
    int w;

    public Node(int v, int w){
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.w, other.w); // 오름차순
    }
}
