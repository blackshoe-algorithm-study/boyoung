package week22_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int str1_n = str1.length;
        int str2_n = str2.length;

        int[][] dp = new int[str1_n+1][str2_n+1]; // 1,1부터 시작

        for(int i=1; i<str1_n; i++){
            for(int j=1; j<str2_n; j++){
                if(str1[i-1]==str2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    
                }
            }
        }
    }
}
