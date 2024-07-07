package week15_0707;

import java.io.*;
import java.util.*;

public class 팰린드롬 {
    static boolean[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) dp[i][i] = true;
        for(int i=1; i<=N-1; i++){ 
            if(arr[i] == arr[i+1]) dp[i][i+1] = true;
        }
        //3개이상..
        

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            if(dp[S][E]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);

    }
}
