package week3_0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소_힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                if(heap.isEmpty()){
                    sb.append(0).append('\n');
                }
                else{
                    sb.append(heap.poll()).append('\n');
                }
            }
            else{
                heap.add(val);
            }
        }
        System.out.print(sb);
    }
}

// // 낮은 숫자가 우선순위가 높은 방식 -> 최소힙
// PriorityQueue<Integer> pq = new PriorityQueue<>();
// // 높은 숫자가 우선순위가 높은 방식 -> 최고힙
// PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
