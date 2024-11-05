package week24_1029;
/*
 * dijkstra
 * 1. 하나의 정점에서 모든 정점까지의 최단거리
 * 2. 그래프 가중치는 양수인 경우만
 * 3. 우선순위 큐 사용 -> 최단거리를 찾기 때문에
 * 4-1. 그리디 알고리즘 : 방문하지 않은 노드 중 가장 비용이 적은 노드 선택
 * 4-2. 다이나믹 프로그래밍 : 해당 노드로부터 갈 수 있는 노드들의 비용을 갱상
 */
import java.io.*;
import java.util.*;

// X로 갔던길을 돌아올 때 동일한 루트로 돌아와야함
// 단방향 가중치만 주어졌고 양방향처럼 돌아올 때도 해당 간선 가중치 활용
// 현재 노드에 초점을 맞추고 현재 노드의 인접 노드들 dist를 갱신하기 (INF로 초기화가 안되어 있을 수도 있고, 초기화가 되어 있더라도 방문 전이므로 최소값으로 갱신 가능)

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

    static class Node{
        int v;
        int w;
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}
