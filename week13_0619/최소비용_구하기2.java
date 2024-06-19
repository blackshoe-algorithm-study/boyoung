package week13_0619;

import java.io.*;
import java.util.*;

public class 최소비용_구하기2 {
    static int n, m;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int[] prev;
    static int start_city, end_city;
    static ArrayList<Integer> route;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];
        prev = new int[n+1];
        route = new ArrayList<>();

        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }

        StringTokenizer st;
        for(int i=1; i<m+1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, weight)); 
        }

        st = new StringTokenizer(br.readLine());
        start_city = Integer.parseInt(st.nextToken());
        end_city = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dist[end_city]);

        for(int i=end_city; i != -1; i=prev[i]){
            route.add(i);
        }

        Collections.reverse(route);

        System.out.println(route.size());
        for(int city : route){
            System.out.print(city + " ");
        }

    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start_city, 0));
        dist[start_city] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int c = now.v;

            if(visited[c]) continue;
            visited[c] = true;
            for(Node next : graph[c]){
                if(dist[next.v] > dist[c]+ next.w){
                    dist[next.v] = dist[c]+ next.w;
                    Node update = new Node(next.v, dist[next.v]);
                    pq.add(update);
                    prev[next.v] = c; 
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
