package week20_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기 {
    static int N;
    static int M;
    static String[] chess;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chess = new String[N];

        for(int i=0; i<N; i++){
            chess[i] = br.readLine();
        }

        System.out.println(find());
    }

    public static int find(){
        int min = Integer.MAX_VALUE;

        for(int i=0; i<N-7; i++){ // 8*8이 나올 수 있는 경우의 수
            for(int j=0; j<M-7; j++){
                for(int k=0; k<2; k++){
                    char first = k==0 ? 'W': 'B';

                    int count = 0;
                    for(int n=i; n<i+8; n++){ // 8*8체스판 탐색 후 색깔이 다른거 변경
                        for(int m=j; m<j+8; m++){
                            if(first != chess[n].charAt(m)) count++;

                            first = first == 'W'?'B':'W';
                        }
                        first = first == 'W'?'B':'W';
                    }

                    min = Math.min(min, count);

                }
            }
        }
        return min;
    }
}
