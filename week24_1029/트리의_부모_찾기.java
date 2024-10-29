package week24_1029;

import java.io.*;
import java.util.*;

public class 트리의_부모_찾기 {
    static int N;
    static int[] node;
    static int[] parent;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        node = new int[N+1];
        parent = new int[N+1];
        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i=2; i<N+1; i++){
            System.out.println(parent[i]);
        }
    }

    static void dfs(int node){
        visited[node] = true;

        for(int near:list[node]){
            if(!visited[near]){
                parent[near] = node;
                dfs(near);
            }
        }
    }
}
