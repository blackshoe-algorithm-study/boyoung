package week25_1105;

import java.io.*;
import java.util.*;

public class 금민수의_개수 {
    static int A;
    static int B;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        recursive("");
        System.out.println(count);

        /*int count = 0; //메모리 초과

        for (int i = A; i <= B; i++) {
            String str = String.valueOf(i);
            boolean flag = true;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != '4' && str.charAt(j) != '7') { // 조건 수정
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        System.out.println(count);*/
    }

    static void recursive(String numStr){
        if(!numStr.isEmpty()){
            long num = Long.parseLong(numStr);
            if(num > B) return;
            if(num >= A) count++;
        }

        recursive(numStr + "4");
        recursive(numStr + "7");
    }
}
