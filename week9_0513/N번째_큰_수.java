package week9_0513;

import java.io.*;
import java.util.*;

public class N번째_큰_수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //오름차순

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(pq.size() == N){
                    if(pq.peek() < num){
                        pq.poll();
                        pq.add(num);
                    }
                }else{
                    pq.add(num);
                }
            }
        }

        System.out.println(pq.poll());
    }
}
