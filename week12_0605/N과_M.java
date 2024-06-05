package week12_0605;

import java.io.*;
import java.util.*;

public class N과_M {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        answer = new int[M];

        dfs(0);
    }

    public static void dfs(int depth){
        if(M == depth){
            for(int i=0; i<M ; i++){
                System.out.print(answer[i]+ " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<N+1; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
