package week4_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
    static int N;
    static int[][] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        solution(0, 0);

        System.out.println(result);
    }   

    public static void solution(int i, int profit){
        if(i >= N){
            if(result < profit){
                result = profit;
            }
            return;
        }
        if(i + arr[i][0] <= N){
            solution(i + arr[i][0], profit + arr[i][1]);
        }
        else{
            solution(i + arr[i][0], profit);
        }
        solution(i + 1, profit);
    }
}
