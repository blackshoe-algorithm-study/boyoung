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

        for(int i=2; i*i<N+1; i++){ // i제곱이 N보다 작을때까지만 동작하도록하기
            if(isPrime[i]){
                for(int j=i*2; j<N+1; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2; i<N+1; i++){
            if(isPrime[i]){
                list.add(i);
            }
        }

        // 투 포인터

        int left = 0;
        int right = 0;
        int sum = 2;
        int count = 0;
        //N의 값보다 합이 작으면 right를 올려서 더해주고
        //크면 left를 올려서 빼주고
        //left와 right가 같아지면 끝

        while(left < list.size() && right < list.size()){
            if(sum < N){
                if(right + 1 >= list.size()) break;
                sum += list.get(++right);
            }
            else if(sum > N){
                sum -= list.get(left++);
            }
            else{
                count++;
                sum -= list.get(left++);
            }
        }

        System.out.println(count);

    }
}
