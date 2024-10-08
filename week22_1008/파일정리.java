package week22_1008;

import java.io.*;
import java.util.*;

public class 파일정리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String text = br.readLine();
            String[] arr = text.split("\\.");
            map.put(arr[1], map.getOrDefault(arr[1], 0)+1);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for(String str:keys){
            System.out.println(str + " " + map.get(str));
        }
    }
}
