package week3_0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린_괄호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(),"-");
        int first=0;
        int sum = 0;
        while(st1.hasMoreTokens()){ // -로 연결된 연산까지 수행
            StringTokenizer st2 = new StringTokenizer(br.readLine(),"+");
            while(st2.hasMoreTokens()){ // +로 연결된 연산
                sum += Integer.parseInt(st2.nextToken());
            }
        }
        

    }
}
