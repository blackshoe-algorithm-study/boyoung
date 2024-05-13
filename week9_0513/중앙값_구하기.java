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

        for(int i=0; i<T; i++){
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<M+1; j++){
                int v = Integer.parseInt(st.nextToken());
                if(j % 2 == 1){
                    pq.add(v);
                    for(int k=0; k<j/2; k++){
                        pq.remove();
                    }
                    sb.append(pq.poll()).append(" ");
                }else{
                    pq.add(v);
                }
            }
        }

        System.out.println(sb);
    }
}
