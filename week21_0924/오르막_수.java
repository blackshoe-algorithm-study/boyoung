package week21_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오르막_수 {
    static int N;
    static int[] dp;
    static int result=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[10];

        for(int i=0; i<10; i++){
            dp[i]=1;
        }

        for(int i=2; i<=N; i++){
            for(int j=1; j<10; j++){
                dp[j] += dp[j-1];
                dp[j] %= 10007;
            }
        }

        for(int element : dp){
            result += element;
            result %= 10007;
        }

        System.out.println(result);
    }
}
