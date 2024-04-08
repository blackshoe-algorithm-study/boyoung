package week4_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
    static int N;
    static int[][] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        solution(0, 0);

        System.out.println(result);
    }   
    //dfs 풀이법
    public static void solution(int i, int profit){
        if(i >= N){ //퇴사일에 다다르면 현재까지 계산한 이익을 비교하여 큰 쪽으로 업데이트한다
            if(result < profit){
                result = profit;
            }
            return;
        }
        //현재 일을 선택할 경우, 일을 완료하는데 걸리는 시간이 퇴사일을 넘지 않아야 한다. 넘지 않는다면, 받을 금액을 이익에 더한 후 현재 일을 마쳤을 때의 일자로 넘어가서 DFS 탐색을 반복한다.
        if(i + arr[i][0] <= N){
            solution(i + arr[i][0], profit + arr[i][1]);
        }
        else{
            solution(i + arr[i][0], profit);
        }
        //현재 일을 선택하지 않을 경우, 이익은 그대로 둔 채 다음날로 넘어가 DFS 탐색을 반복한다.
        solution(i + 1, profit);
    }
}
