package week2_0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대_힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
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
