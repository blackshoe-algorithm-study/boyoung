package week9_0513;

import java.io.*;
import java.util.*;

public class 중앙값_구하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        // for(int i=0; i<T; i++){
        //     int M = Integer.parseInt(br.readLine());
        //     st = new StringTokenizer(br.readLine());
        //     for(int j=1; j<M+1; j++){
        //         int v = Integer.parseInt(st.nextToken());
        //         if(j % 2 == 1){
        //             pq.add(v);
        //             for(int k=0; k<j/2; k++){
        //                 pq.remove();
        //             }
        //             sb.append(pq.poll()).append(" ");
        //             pq = new PriorityQueue<>();
        //         }else{
        //             pq.add(v);
        //         }
        //     }
        // }

        // System.out.println(sb);

        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(br.readLine());
            sb.append((M+1)/2).append('\n');

            //최소 힙 -> 내림차순 정렬, 최대 힙 -> 오름차순 정렬
            //홀수 번째 -> 최대힙에 저장, 짝수 번째 -> 최소힙에 저장
            //최소힙의 최대값이 최대힙의 최소값보다 큰 경우 -> 둘이 교환
            //교환 결과 최소힙은 최대힙보다 작은 원소들이 정렬됨
            //최대 힙에서 가장 작은 값을 중앙값으로 가져옴(최소 힙보다 하나가 많은 것이 중앙값)
            PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>();
        }
    }
}
