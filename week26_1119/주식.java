package week26_1119;

import java.io.*;
import java.util.*;
/*
 * 역방향으로 탐색할 때 판매하는 가격의 큰 값을 먼저 얻어서 비교할 수 있음
 * 순방향 시 미래 최대값을 알아야하는 복잡한 로직이 필요함
 * 역방향에서 큰 값을 찾으면 그 앞에 있는 가격들은 더 큰 최대값을 찾아내지 않는이상 해당하는 최대값으로 판매되는 것이 가장 큰 이익
 */
public class 주식 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N ;

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long profit = 0;

            int[] prices = new int[N];

            for(int i=0; i<N; i++){
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for(int i=N-1; i>=0; i--){
                max = Math.max(prices[i], max);
                profit += max - prices[i];
            }

            sb.append(profit).append('\n');
        }

        System.out.print(sb.toString());
    }
}

/*
---> greedy 문제
주식 문제에서는 최대 계산 가능한 이익이:

최대 가격: 10,000
최대 개수: 1,000,000
최악의 경우: 10,000 × 1,000,000 = 10,000,000,000 (100억)

이므로 int (21억)의 범위를 넘어서기 때문에 long을 사용해야 함

long profit 사용을 안해서 문제 틀림
 */