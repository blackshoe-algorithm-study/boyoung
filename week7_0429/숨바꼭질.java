package week7_0429;

import java.io.*;
import java.util.*;


public class 숨바꼭질 {
    static int[] visited = new int[100001];
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = bfs(N, K);

        System.out.println(answer);

    }

    static int bfs(int N, int K){
        queue.add(N);
        visited[N] = 1;

        while(!queue.isEmpty()){
            int current = queue.remove();

            if(current == K){
                return visited[K]-1;
            }

            if(current-1>=0 && current-1<=100000 && visited[current-1] == 0){ // else if -> return -1, current-1<=100000 -> runTimeError
                visited[current-1] = visited[current] + 1;
                queue.add(current-1);
            }

            if(current+1>=0 && current+1<=100000 && visited[current+1] == 0){
                visited[current+1] = visited[current] + 1;
                queue.add(current+1);
            }

            if(current*2>=0 && current*2<=100000 && visited[current*2] == 0){
                visited[current*2] = visited[current] + 1;
                queue.add(current*2);
            }
        }

        return -1;

    }
}
