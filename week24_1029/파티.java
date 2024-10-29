package week24_1029;

import java.io.*;
import java.util.*;

public class 파티 {
    static int N;
    static int M;
    static int X;
    static ArrayList<Node>[] list;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];

        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, w));
        }

        int maxDistance = 0;
        for(int i=1; i<=N; i++){
            if(i != X){
                int distToX = dijkstra(i, X);
                int dijkstra = dijkstra(X, i);
                maxDistance = Math.max(maxDistance, distToX+dijkstra);
            }
        }

        System.out.println(maxDistance);
    }

    static void dijkstra(int start, int end){
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start]=0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.w)); // 오름차순, 내림차순의 경우 -n.w
        
    }
}

class Node{
    int end;
    int w;
    public Node(int end, int w){
        this.end = end;
        this.w = w;
    }
}