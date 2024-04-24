package week6_0422;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && dp[j] >= dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        Arrays.sort(dp);

        System.out.println(dp[N-1]);
    }
    
}
