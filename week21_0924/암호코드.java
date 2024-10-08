// DP 이 문제 어려웠다!!!

package week21_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호코드 {
    static final int MOD = 1000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] dp = new int[str.length()+1]; // 해당 자리수까지 나올 수 있는 경우의 수
        dp[0]=1;

        for(int i=1; i<=str.length(); i++){
            int c = str.charAt(i-1) - '0';
            if(c>=1 && c<=9){
                dp[i] += dp[i-1];
                dp[i] %=MOD;
            }

            if(i==1) continue; // 아래 2자리를 보는 로직을 거치지 않음

            int pre = str.charAt(i-2) - '0';

            if(i==0) continue; // 0으로 시작하지 않음

            int value = pre*10+c;

            if(value>=10 && value<=26){
                dp[i] += dp[i-2]; // 앞에서 해당 한자리 수까지 온 경우 + 해당 두자리 수 경우 까지 더해주는 게 댐
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[str.length()]);
    }
}
