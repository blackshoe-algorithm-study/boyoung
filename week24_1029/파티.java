package week24_1029;
/*
 * dijkstra
 * 1. greedy와 같이 각 정점까지의 최단거리
 * 2. 그래프 가중치는 양수인 경우만
 */
import java.io.*;
import java.util.*;

// X로 갔던길을 돌아올 때 동일한 루트로 돌아와야함
// 단방향 가중치만 주어졌고 양방향처럼 돌아올 때도 해당 간선 가중치 활용

public class 파티 {
    static int N;
    static int M;
    static int X;
    static ArrayList<Node>[] ToX;
    static ArrayList<Node>[] FromX;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        ToX = new ArrayList[N+1];
        FromX = new ArrayList[N+1];

        for(int i=0; i<N+1; i++){
            ToX[i] = new ArrayList<>();
            FromX[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            ToX[a].add(new Node(b, w));
            FromX[b].add(new Node(a,w));
        }

        int[] distToX = dijkstra(X,ToX);
        int[] distFromX = dijkstra(X, FromX);

        int maxDistance = 0;
        for(int i=1; i<=N; i++){
            if(i != X){
                maxDistance = Math.max(maxDistance, distToX[i]+distFromX[i]);
            }
        }
        
        System.out.println(maxDistance);
    }

    static int[] dijkstra(int start, ArrayList<Node>[] graph){
        int[] dist = new int[N+1]; // INF이면 방문하지 않은 노드 -> visited 대신 사용
        Arrays.fill(dist, INF);
        dist[start]=0;

        //최단 시간에 오고 가는 학생들 중 그 시간이 최대인 노드를 찾는 것
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.w)); // 오름차순, 내림차순의 경우 -n.w
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();

            for(Node next:graph[current.v]){
                int newDist = dist[current.v] + next.w; // 현재 노드까지의 최단 거리 + 다음 노드의 가중치
                if(dist[next.v] > newDist) {
                    dist[next.v] = newDist;
                    pq.add(new Node(next.v, newDist));
                }
            }
        }

        return dist;
        // 특정 노드 start에서 시작해서 X까지 
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