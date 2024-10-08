package week20_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주_시식 {
    static int N;
    static int[] dp;
    static int[] wine;
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        wine = new int[N+1];

        for(int i=1; i<=N; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        if (N >= 1) dp[1] = wine[1];
        if (N >= 2) dp[2] = wine[1] + wine[2]; 

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], 
                             Math.max(wine[i] + dp[i - 2], 
                                      wine[i] + wine[i - 1] + dp[i - 3]));
        }

        System.out.println(dp[N]);
    }
}
