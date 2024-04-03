package week3_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수_찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        while(st.hasMoreTokens()){
            map.put(Integer.parseInt(st.nextToken()), 0);
        }
        
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                sb.append(1).append('\n');
            }
            else{
                sb.append(0).append('\n');
            }
        }

        System.out.print(sb);
    }
}
