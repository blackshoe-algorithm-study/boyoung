package week11_0527;

import java.io.*;
import java.util.*;

public class 치킨_배달 {
    static int N;
    static int M;
    static int[][] city;
    static ArrayList<Location> house;
    static ArrayList<Location> chicken;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                if(city[i][j] == 1){
                    house.add(new Location(i, j));
                }
                else if(city[i][j] == 2){
                    chicken.add(new Location(i, j));
                }
            }
        }

        //backtracing
        //하나의 집에 각각의 치킨집 거리 구하기
        //visited로 재귀, 백트래킹

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
