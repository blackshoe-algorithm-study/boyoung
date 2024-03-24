package week1_0320;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 베스트셀러 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        
        for(int i=0; i<N; i++){
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0)+1);
            max = Math.max(max, map.get(title));
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(String key: list){
            if(map.get(key)==max){
                System.out.println(key);
                break;
            }
        }

        br.close();
    }
}
