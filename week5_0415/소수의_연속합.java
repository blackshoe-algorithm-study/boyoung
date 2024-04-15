package week5_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소수의_연속합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        // N이하의 소수 구하기
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i<N+1; i++){
            if(isPrime[i]){
                for(int j=i*i; j<N+1; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=1; i<N+1; i++){
            if(isPrime[i]){
                list.add(i);
            }
        }
    }
}
