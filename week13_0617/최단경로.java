package week13_0617;

import java.io.*;
import java.util.*;

public class 최단경로 {
    static int V, E, K;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.v;

            if (visited[u]) continue;
            visited[u] = true;

            for (Node next : graph[u]) {
                if (dist[next.v] > dist[u] + next.w) {
                    dist[next.v] = dist[u] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.w, other.w);
    }
}
