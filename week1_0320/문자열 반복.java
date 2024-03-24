package week1_0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            int num = Integer.parseInt(str[0]); // 2
            String alpha = str[1]; // abc
            for(int j=0; j<alpha.length(); j++){ // 문자 개수
                for(int k=0; k<num; k++){ 
                    sb.append(alpha.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}