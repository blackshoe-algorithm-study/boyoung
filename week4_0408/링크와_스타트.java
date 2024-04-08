package week4_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 링크와_스타트 {
    static int N, result;
    static int[][] S;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        check = new boolean[N]; // 같은 팀에 속해있는지 판단하기 위함
        result = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0);
        System.out.println(result); 
    }
    
    //부분집합 계산
    public static void solution(int count){
        if(count == N){ // 모든 선수들의 소속이 정해진 경우 능력치 계산 로직
            int start = 0;
            int link = 0;
            
            //모든 선수들의 소속을 확인하여 쌍으로 능력치 계산
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    if(check[i] != check[j]) continue;
                    if(check[i]) { 
                        start += S[i][j] + S[j][i];
                    }
                    else{
                        link += S[i][j] +S[j][i];
                    }
                }
            }

            int diff = Math.abs(start - link);
            if(diff < result) result = diff;

            return;
        }
        //재귀함수 사용

        check[count] = true; //현재 인덱스의 선수를 팀에 포함할때
        solution(count + 1);
        check[count] = false;//현재 인덱스의 선수를 팀에 포함하지 않을때
        solution(count + 1);
        // 결국에는 전부다 한팀에 몰빵되는 결과(전부 true or false)도 계산이 되지만
        // 위의 계산에서 어차피 최소값을 고르는 경우에서 걸러짐
    }
    
}
