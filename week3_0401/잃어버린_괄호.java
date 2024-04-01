package week3_0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린_괄호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
        int result = Integer.MAX_VALUE; //result = 0 은 안됌

        while(st1.hasMoreTokens()){
            int temp = 0;
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
            while(st2.hasMoreTokens()){
                temp+=Integer.parseInt(st2.nextToken());
            }
            if(result == Integer.MAX_VALUE){
                result = temp;
            }
            else{
                result -= temp;
            }
        }
        System.out.print(result);        
    }
}
