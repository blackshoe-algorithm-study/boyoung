//백트레킹으로 부분조합 만들기
package week19_0814;

import java.io.*;
import java.util.*;

public class 감소하는_수 {
    static int N;
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N<=10){
            System.out.println(N);
            return;
        }

        if(N>=1023){ // 1022번째가 9876543210임 그 이후로 없음
            // list index에서 0~1022까지 1023개가 존재함으로 1023이후 부터는 취급하지 않음
            System.out.println(-1);
            return;
        }

        for(int i=0; i<10; i++){
            dfs(i, 1);
        }

        Collections.sort(list);

        System.out.println(list.get(N));
    }

    static void dfs(long num, int index){ // int로 했더니 틀림
        if(index>10) return; //98765432210 -> 10자리
        list.add(num);

        for(int i=0; i<num%10; i++){
            dfs(num*10 + i, index+1);
        }
    }
}
