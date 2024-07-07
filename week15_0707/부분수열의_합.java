package week15_0707;

import java.io.*;
import java.util.*;

public class 부분수열의_합 {
    static int N;
    static int[] S;
    static boolean[] checked;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        checked = new boolean[100000*20+1]; //최대수:100000이고 N값이 20개까지 있을 수 있음

        for(int i=0; i<N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        for(int i=1; i<checked.length; i++){
            if(!checked[i]){
                System.out.println(i);
                break;
            }
        }

    }

    public static void dfs(int depth, int sum){
        if(depth == N){
            checked[sum] = true;
            return;
        }

        dfs(depth+1, sum + S[depth]);
        dfs(depth+1, sum);
    }
}
