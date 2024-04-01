package week3_0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class ATM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        //초기화
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        //정렬하기
        Collections.sort(list);
        int result = 0;
        //계산하기
        for(int i=0; i<N; i++){
            for(int j=0; j<=i; j++){
                result += list.get(j);
            }
        }

        System.out.print(result);
    }
}
