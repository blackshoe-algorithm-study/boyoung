package week11_0527;

import java.io.*;
import java.util.*;

public class 예산 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int left = 0;//Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            //left = Math.min(arr[i], left);
            right = Math.max(arr[i], right);
        }

        while(left <= right){
            int mid = (left + right)/2;
            int sum = 0;
            for(int i=0; i<N; i++){
                if(arr[i] < mid){
                    sum += arr[i];
                }else{
                    sum += mid;
                }
            }
            if(sum<=M){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
