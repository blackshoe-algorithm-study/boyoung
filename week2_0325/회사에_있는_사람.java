package week2_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회사에_있는_사람 {
    public static void main(String[] args) throws IOException{
        //hashmap에서 (key: 이름, value: 출입상태)로 활용
        //hashmap에 저장함, 이때 key값이 이미 map에 존재하는 경우 해당 원소 삭제(출입기록이 있다면 다른 기록은 반드시 퇴근 기록이기 때문)
        //그러면 value값이 enter인 사람만 존재하게 됨
        //key값을 기준으로 역정렬 후 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            String name = st.nextToken();
            String status = st.nextToken();
            if(map.get(name) != null){
                map.remove(name);
            }
            else{
                map.put(name, status);
            }
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.reverse(list);

        for(String a : list){
            System.out.println(a);
        }

    }
}
