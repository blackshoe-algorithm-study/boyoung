// 
package week13_0619;

import java.io.*;
import java.util.*;

public class 파티 {
    static int N, M, X;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, w));
            graph[end].add(new Node(start, w)); // 양방향 간선 추가
        }

        int[] dist_to_X = dijkstra(X); // X로부터 각 노드까지의 최단 거리
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            if (i == X) continue; // X 자신은 제외
            int[] dist_from_i = dijkstra(i); // i로부터 각 노드까지의 최단 거리
            max = Math.max(max, dist_to_X[i] + dist_from_i[X]);
        }

        System.out.println(max);
    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int current = now.v;

            if (visited[current]) continue;
            visited[current] = true;

            for (Node next : graph[current]) {
                if (dist[next.v] > dist[current] + next.w) {
                    dist[next.v] = dist[current] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }
}

class Node implements Comparable<Node> {
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.w, other.w);
    }
}
