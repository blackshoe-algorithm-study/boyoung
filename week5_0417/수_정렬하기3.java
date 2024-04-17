package week5_0417;

import java.io.*;

public class 수_정렬하기3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int count[] = new int[10001];
		for(int i=0; i<N; i++) {
			count[Integer.parseInt(br.readLine())]++;
		}

		for(int i=1; i<10001; i++) {
			while(count[i] > 0) {
				sb.append(i).append('\n');
				count[i]--;
			}
		}

		System.out.println(sb);
    }
    
}
