package week11_0527;

import java.io.*;
import java.util.*;

public class 시험_감독 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result=N;

        for(int i=0; i<N; i++){
            arr[i] -= B;
            if(arr[i] <= 0) continue;
            if(arr[i]%C != 0){
                result += arr[i]/C;
                result++;
            }else{
                result += arr[i]/C;
            }
        }

        System.out.println(result);
    }
}
