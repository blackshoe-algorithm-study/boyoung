package week3_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진법_변환 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int num = 0;
        int result = 0;

        for(int i=0; i<N.length(); i++){
            char alpha = N.charAt(i);
            if( alpha >= 'A' && alpha <= 'Z'){
                num = (alpha - 'A' + 10); 
            }
            else{
                num = (alpha - '0');
            }
            result += num * Math.pow(B, N.length()-1-i);
        }
        System.out.print(result);
    }
}
