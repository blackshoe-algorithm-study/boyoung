package week10_0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N-1;
        long min = Integer.MAX_VALUE;
        int answerleft = 0, answerright = 0;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                answerleft = left; answerright = right;
            }
            if(sum >= 0){
                right--;
            }else{
                left++;
            }

        }

        System.out.println(arr[answerleft] + " " + arr[answerright]);

    }
    
}
