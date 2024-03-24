package week1_0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_반복{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] str = br.readLine().split(" ");
            int R = Integer.parseInt(str[0]);
            String S = str[1];
            for(int j=0; j<S.length(); j++){
                for(int k=0; k<R; k++){ 
                    sb.append(S.charAt(j));
                }
            }
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}