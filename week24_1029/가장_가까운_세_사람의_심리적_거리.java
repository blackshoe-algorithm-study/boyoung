package week24_1029;

import java.io.*;
import java.util.*;

public class 가장_가까운_세_사람의_심리적_거리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int n;
        String[] mbti;

        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            mbti = new String[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            if(n>32){ //비둘기집 원리? 없으면 시간초과
                sb.append(0).append('\n');
                continue;
            }

            for(int i=0; i<n; i++){
                mbti[i] = st.nextToken();
            }

            int min=Integer.MAX_VALUE;

            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    for(int k=j+1; k<n; k++){
                        int sum = 0;
                        for(int l=0; l<4; l++){
                            if(mbti[i].charAt(l) != mbti[j].charAt(l)) sum+=1;
                            if(mbti[j].charAt(l) != mbti[k].charAt(l)) sum+=1;
                            if(mbti[i].charAt(l) != mbti[k].charAt(l)) sum+=1;
                        }
                        min = Math.min(sum, min);
                        if(min==0) break;
                    }
                }
            }
            sb.append(min).append('\n');
        }
        System.out.print(sb.toString());
    }
}

