import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA_비밀번호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        int[] dnaArr = new int[4]; // {A,C,G,T}
        char[] pw = new char[S];
        int[] check = new int[4];
        int[] exist = new int[4];
        int result=0;

        for(int i=0; i<S; i++){
            pw[i] = str.charAt(i);
            if(pw[i] == 'A') dnaArr[0]++;
            if(pw[i] == 'C') dnaArr[1]++;
            if(pw[i] == 'G') dnaArr[2]++;
            if(pw[i] == 'T') dnaArr[3]++;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            check[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<4; i++){
            if(exist[i] >= check[i]) result++;
        }

        for(int i=0; i<P; i++){ // 슬라이딩 시 개수 비교
            if(pw[i] == 'A') exist[0]++;
            if(pw[i] == 'C') exist[1]++;
            if(pw[i] == 'G') exist[2]++;
            if(pw[i] == 'T') exist[3]++;
        }

        

    }
}
