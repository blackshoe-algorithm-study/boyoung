package week5_0417;

import java.io.*;
import java.util.*;

public class 나무_자르기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int min =0, max = 0, mid = 0;
        long sum = 0;

        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st2.nextToken());
            if(max < tree[i]){
                max = tree[i];
            }
        }

        while(min < max){
            mid = (min + max)/2;
            sum = 0;
            for(int i=0; i<N; i++){
                int get = tree[i] - mid;
                if(get > 0){
                    sum += get;
                }
            }

            if(sum < M){
                max = mid;
            }
            else {
                min = mid + 1; // 기존 mid 값을 넘어가야하기 때문에 기존 mid값에 + 1
            }
        }
        System.out.println(min - 1);
    }
}
