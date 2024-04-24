package week6_0422;

import java.io.*;
import java.util.*;

public class 쉬운_계단_수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[][] = new int[N+1][10];

        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }

    }
    
}
