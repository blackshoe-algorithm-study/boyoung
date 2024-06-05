package week12_0605;

import java.io.*;
import java.util.*;

public class 날짜_계산 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        int e=0, s=0, m=0;

        while(true){
            e++;
            s++;
            m++;
            count++;
            if(e>15) e=1;
            if(s>28) s=1;
            if(m>19) m=1;

            if(e==E && s==S && m==M) break;
        }

        System.out.println(count);
    }
}
