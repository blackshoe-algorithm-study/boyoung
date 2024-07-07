package week15_0707;

import java.io.*;
import java.util.*;

public class 팰린드롬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        boolean[][] dp = new boolean[N+1][N+1];

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) dp[i][i] = true; // 길이 1인 팰린드롬
        for(int i=1; i<N; i++){ 
            if(arr[i] == arr[i+1]) dp[i][i+1] = true; // 길이 2인 팰린드롬
        }
        for(int length=2; length<N; length++){
            for(int start=1; start+length<=N; start++){
                int end = start + length;
                if(arr[start] == arr[end] && dp[start+1][end-1]) {
                    dp[start][end] = true; // 길이 3 이상인 팰린드롬
                }
            }
        }

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
