package week4_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 링크와_스타트 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        boolean[] check = new boolean[N]; // 같은 팀에 속해있는지 판단하기 위함

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // N개일떄, (1 개, N-1 개 ), (2개, N-2개), (3개, N-3개) ...
        for(int i=1; i<N; i++){
            solution(i, check, arr);
        }     
    }

    public static void solution(int idx, boolean[] check, int[][] arr){
        int start = 0;
        int end = 0;

        for(int i=0; i<idx; i++){
            for(int j=i+1; j<idx; j++){
                if(check[i] == true && check[j] == true) { 
                    start += arr[i][j] + arr[j][i];
                }
                else if(check[i] == false && check[j] == false) { 
                    end += arr[i][j] +arr[j][i];
                }
            }
        }
    }
    
}
