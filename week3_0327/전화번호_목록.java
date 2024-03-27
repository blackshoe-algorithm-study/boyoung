package week3_0327;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class 전화번호_목록 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int size = Integer.parseInt(br.readLine());
            String[] phonebook = new String[size];
            Map<String, Integer> map = new HashMap<>();
            boolean flag = false;
            for(int j=0; j<size; j++){ // phonebook,Hashmap 만들기
                String number = br.readLine();
                phonebook[j] = number;
                map.put(number, j);
            }

            for(int k=0; k<size; k++){ // phonebook의 번호 루프
                for(int l=0; l<phonebook[k].length(); l++){ // 번호 하나의 문자열 루프
                    if(map.containsKey(phonebook[k].substring(0, l))){
                        flag = true;
                    }
                }
            }

            if(flag == true){
                sb.append("NO").append('\n');
            }
            else if(flag == false){
                sb.append("YES").append('\n');
            }
        }
        System.out.println(sb);
    }  
}
