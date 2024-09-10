package week20_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙고 {
    static int[][] bingo = new int[5][5];
    static int bingoCount = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int num = Integer.parseInt(st.nextToken());

                findNum(num); // 사회자 부른거 0으로 바꿈
                findBingo();

                if(bingoCount>=3){
                    System.out.println(i*5+j+1);
                    return;
                }

            }
        }


    }

    public static void findNum(int num){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(bingo[i][j] == num){
                    bingo[i][j] = 0;
                }
            }
        }
    }

    public static void findBingo(){
        bingoCount = 0;

        for(int i=0; i<5; i++){
            int rowCount=0;
            int colCount=0;
            for(int j=0; j<5; j++){
                if(bingo[i][j] == 0) rowCount++;//가로
                if(bingo[j][i] == 0) colCount++;//세로
            }
            if(rowCount==5) bingoCount++;
            if(colCount==5) bingoCount++;
        }

        int leftCount=0;
        int rightCount=0;

        for(int i=0; i<5; i++){
            if(bingo[i][i]==0) rightCount++;
            if(bingo[i][4-i]==0) leftCount++;
        }

        if(leftCount==5) bingoCount++;
        if(rightCount==5) bingoCount++;
    }
}
