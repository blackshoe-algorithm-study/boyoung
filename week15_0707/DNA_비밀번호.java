package week15_0707;
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
        int[] min = new int[4];
        int[] exist = new int[4];
        int result = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }
        
        // 초기 P 길이의 윈도우 설정
        for (int i = 0; i < P; i++) {
            addChar(exist, str.charAt(i));
        }
        
        // 첫 번째 윈도우 검사
        if (isValid(exist, min)) result++;
        
        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            addChar(exist, str.charAt(i)); // 새로운 문자를 추가
            removeChar(exist, str.charAt(i - P)); // 이전 문자를 제거
            
            if (isValid(exist, min)) result++;
        }
        
        System.out.print(result);
    }
    
    private static void addChar(int[] exist, char c) {
        if (c == 'A') exist[0]++;
        if (c == 'C') exist[1]++;
        if (c == 'G') exist[2]++;
        if (c == 'T') exist[3]++;
    }
    
    private static void removeChar(int[] exist, char c) {
        if (c == 'A') exist[0]--;
        if (c == 'C') exist[1]--;
        if (c == 'G') exist[2]--;
        if (c == 'T') exist[3]--;
    }
    
    private static boolean isValid(int[] exist, int[] min) {
        for (int i = 0; i < 4; i++) {
            if (exist[i] < min[i]) {
                return false;
            }
        }
        return true;
    }
}
