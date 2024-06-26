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
        long sum = 0; // 나무 길이 최대가 10억이므로 int로 설정시 overflow 발생가능

        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st2.nextToken());
            if(max < tree[i]){
                max = tree[i];
            }
        }
        
        while(min < max){
            mid = (min + max)/2;
            sum = 0;
            for(int i=0; i<tree.length; i++){
                if(tree[i] - mid > 0){
                    sum += tree[i] - mid;
                }
            }

            if(sum >= M){ 
                min = mid + 1;
            }
            else{
                max = mid;
            }
        }   

        System.out.println(max-1); // min-1도 정답
        //while문에 =를 없앤후 min과 max를 동일하게 만들기 어떤 케이스에서든 둘의 값은 같기때문에 -1해주면됌
    }
}
