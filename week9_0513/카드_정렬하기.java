package week9_0513;

import java.io.*;
import java.util.*;

public class 카드_정렬하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;

        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));            ;
        }

        while(pq.size() >= 2){
            int a = pq.poll();
            int b = pq.poll();
            sum += a+b;
            pq.add(a+b);
        }

        System.out.println(sum);
    }
}
