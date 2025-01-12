package week26_1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 슈퍼점프 한번 사용을 고려하는게 너무 어려움
 */
public class 징검다리_건너기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] jump = new int[2][Math.max(4, N+1)]; // jump 배열 크기 수정

        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            jump[0][i] = Integer.parseInt(st.nextToken());
            jump[1][i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][Math.max(4, N + 1)]; // dp 배열 크기 유지
        for (int[] row : dp) {
            Arrays.fill(row, 10000); // 매우 큰 값으로 초기화
        }
        dp[0][1] = 0; // 시작점 초기화
        dp[1][1] = 0; // 슈퍼점프 사용한 경우 초기화

        if (N >= 2) { // N이 2 이상일 경우만 처리
            dp[0][2] = jump[0][1];
        }
        if (N >= 3) { // N이 3 이상일 경우만 처리
            dp[0][3] = Math.min(dp[0][2] + jump[0][2], dp[0][1] + jump[1][1]);
        }

        for (int i = 4; i <= N; i++) { // 4번 돌부터 마지막 돌까지의 비용 계산
            dp[0][i] = Math.min(dp[0][i - 1] + jump[0][i - 1], // i-1번 돌에서 작은 점프로 이동
                    dp[0][i - 2] + jump[1][i - 2]); // i-2번 돌에서 큰 점프로 이동

            if (i >= 4) { // i가 4 이상일 때만 슈퍼점프 계산
                dp[1][i] = Math.min(
                        Math.min(dp[1][i - 1] + jump[0][i - 1], // i-1번 돌에서 작은 점프로 이동
                                dp[1][i - 2] + jump[1][i - 2]), // i-2번 돌에서 큰 점프로 이동
                        dp[0][i - 3] + K // i-3번 돌에서 슈퍼점프 처음 사용
                );
            }
        }

        int answer = Math.min(dp[0][N], dp[1][N]); // 슈퍼점프 사용 여부에 따른 최소값
        System.out.println(answer);
    }
}
