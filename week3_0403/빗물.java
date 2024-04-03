package week3_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st1.nextToken());
        int W = Integer.parseInt(st1.nextToken());

        int[] block = new int[W];
        int[] left = new int[W];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<W; i++){
            block[i] = Integer.parseInt(st2.nextToken());
            if(max < block[i]){
                max = block[i];
            }
            left[i] = max;
        }

        int[] right = new int[W];
        int max2 = 0;
        for(int i=W-1; i>=0; i--){
            if(max2 < block[i]){
                max2 = block[i];
            }
            right[i] = max2;
        }

        int[] result = new int[W];
        for(int i=0; i<W; i++){
            if(left[i] < right[i]){
                result[i] = left[i];
            }
            else{
                result[i] = right[i];
            }
        }

        int answer = 0;
        for(int i=0; i<W; i++){
            answer += result[i] - block[i];
        }

        System.out.print(answer);

    }
}
