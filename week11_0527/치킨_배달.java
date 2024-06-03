package week11_0527;

import java.io.*;
import java.util.*;

public class 치킨_배달 {
    static int N;
    static int M;
    static int[][] city;
    static ArrayList<Location> house;
    static ArrayList<Location> chicken;
    static boolean[] remaining;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1){
                    house.add(new Location(i, j));
                }
                else if(city[i][j] == 2){
                    chicken.add(new Location(i, j));
                }
            }
        }

        remaining = new boolean[chicken.size()];
        backtracking(0, 0);

        System.out.println(min);
    }

    public static void backtracking(int count, int idx){
        if(count == M){ // M개의 치킨집만 남은 경우(M개로 구성된 치킨집 경우)
            int total = 0;
            for(int i=0; i<house.size(); i++){ // 각 집에서
                int houseMin = Integer.MAX_VALUE;
                for(int j=0; j<chicken.size(); j++){ // 모든 치킨집과 거리 계산
                    if(remaining[j] == true){
                        int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        houseMin = Math.min(dist, houseMin); // 하나의 집에 가장 가까운 치킨 집 거리
                    }
                }
                total += houseMin; //도시 치킨거리 계산
            }
            min = Math.min(min, total); // 도시 치킨거리 중 가장 작은 값 도출
            return; // 백트래킹 종료
        }
        for(int i = idx; i<chicken.size(); i++){
            remaining[i] = true;
            backtracking(count + 1, i + 1);
            remaining[i] = false;
        }
    }
}
class Location{
    int x;
    int y;
    
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
