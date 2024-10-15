package week23_1015;

import java.io.*;
import java.util.StringTokenizer;

public class 카잉_달력 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean flag = false;
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            if (y == N) y = 0;

            for(int i=x; i<(M*N); i+=M){
                if(i%N == y){
                    sb.append(i+1).append('\n');
                    flag = true;
                    break;
                }
            }

            if(!flag){
                sb.append(-1).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
