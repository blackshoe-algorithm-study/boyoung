package week3_0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실_배정 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        
        //회의 시간 배열 초기화
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        //오름차순  -> 검색
        Arrays.sort(time, (meet1, meet2) -> {
            if(meet1[1] == meet2[1]){
                return meet1[0] - meet2[0];
            }
            return meet1[1] - meet2[1]; //내림차순 : meet2[1] - meet1[1]
        });
        //반복문 
        int count=1;
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                if(time[i][1] < time[j][0]){
                    i=j;
                    count+=1;
                }
            }
        }
        System.out.print(count);
    }
}
