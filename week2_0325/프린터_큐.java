package week2_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 프린터_큐 {
    public static void main(String[] args) throws IOException{
        //queue에 중요도를 순서대로 넣기
        //queue에서 하나 poll해서 queue 안에 있는 다른 원소들의 중요도와 비교
        //비교했을때, poll한 것보다 더 큰 중요도가 있으면 offer하여 큐의 마지막에 다시 추가
        //poll한 것보다 큰게 없으면 인쇄된 것으로 간주하여 count++(default=0)하기
        //인쇄된 것 중 원하는 원소의 중요도와 일치하는지 확인하기
        //일치한다면 break 후 count 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            LinkedList<int[]> queue = new LinkedList<>();
            StringTokenizer info = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(info.nextToken());
            int target = Integer.parseInt(info.nextToken());
            StringTokenizer element = new StringTokenizer(br.readLine());

            for(int j=0; j<num; j++){
                queue.offer(new int[] {j, Integer.parseInt(element.nextToken())});
            }

            int count = 0;

            while (!queue.isEmpty()){
                int[] a = queue.poll();
                boolean isMax = true;

                for(int l=0; l<queue.size(); l++){
                    if(a[1] < queue.get(l)[1]){
                        queue.offer(a);
                        for(int g=0; g<l; g++){
                            queue.offer(queue.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(isMax == false){
                    continue;
                }

                count++;
                if(a[0] == target){
                    break;
                }

            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
