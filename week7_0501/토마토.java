package week7_0501;

import java.io.*;
import java.util.*;

public class 토마토 {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] tomato;
    static int M, N, H;
    static int greenTomato = 0;
    static int days = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        Queue<Location> q = new LinkedList<>();

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k] == 1){
                        q.add(new Location(i, j, k));
                    }
                    else if(tomato[i][j][k] == 0){
                        greenTomato++;
                    }
                }
            }
        }

        while(greenTomato>0 && !q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Location l = q.poll();
                int x = l.x;
                int y = l.y;
                int z = l.z;

                for(int j=0; j<6; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int nz = z + dz[j];

                    if(nx<0 || ny<0 || nz<0 || nx>=M || ny>=N || nz>=H) continue;
                    if(tomato[nz][ny][nx] != 0)continue; // 토마토가 익은 경우

                    greenTomato--;
                    tomato[nz][ny][nx]=1;
                    q.add(new Location(nx, ny, nz));
                }
            }
            days++;
        }

        System.out.println(greenTomato == 0 ? days:-1);

    }
}

class Location {
    int x, y, z;

    Location(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z; 
    }
}
