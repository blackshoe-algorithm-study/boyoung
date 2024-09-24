package week21_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dp[곡의순서][볼륨]
//마지막 곡의 순서dp[N][]에서 true가 된 가장 큰 볼륨 index값 찾기
public class 기타리스트 {
    static int N, S, M;
    static int[] volume;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        volume = new int[N+1];
        dp = new boolean[N+1][M+1];
        dp[0][S] = true;

        for(int i=1; i<=N; i++){
            volume[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            for(int j=0; j<=M; j++){
                if(dp[i-1][j]){ // 전 곡 수행했던게 계속 계산이 가능하면
                    int plus = j + volume[i];
                    int minus = j - volume[i];

                    if(plus <= M) dp[i][plus] = true;
                    if(minus >= 0) dp[i][minus] = true;
                }
            }
        }

        int result = -1;
        for(int i=M; i>=0; i--){
            if(dp[N][i]) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
