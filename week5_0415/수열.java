package week5_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//10 2
//3 -2 -4 -9 0 3 7 13 8 -3
public class 수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){ // 배열 초기화
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int sum = 0;
        for(int i=0; i<K; i++){
            sum += arr[i];
        }

        int max = sum;

        for(int i=K; i<N; i++){
            sum += arr[i] - arr[i-K];
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}
