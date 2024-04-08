package week4_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피로도 {
    public static void main(String[] args) throws IOException{
        //A<=M이면 계속 A를 더해줌
        //M초과하면 C를 빼줌
        //24번 반복함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0; 
        int tired = 0; // 피로도

        for(int i=0; i<24; i++){
            if(tired + A <= M){
                tired += A;
                count++;
            }
            else{
                tired -= C;
                if(tired < 0) tired = 0;
            }
        }

        System.out.println(count*B);
    } 
}
