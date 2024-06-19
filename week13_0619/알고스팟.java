package week13_0619;

import java.io.*;
import java.util.*;

public class 알고스팟{
    static int M, N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<N+1; i++){
            String str = br.readLine();
            for(int j=1; j<M+1; j++){
                map[i][j] = Character.getNumericValue(str.charAt(j-1));
            }
        }

        int count = bfs(1, 1);

        System.out.println(count);
    }

    public static int bfs(int x, int y){
        PriorityQueue<Point> q = new PriorityQueue<>();
        Point start = new Point(x, y, 0);
        q.add(start);
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == N && p.y==M) return p.count;

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<1 || ny<1 || nx>=N+1 || ny>=M+1) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    q.add(new Point(nx, ny, p.count+1));
                    visited[nx][ny] = true;
                }
                
                if(map[nx][ny] == 0 && !visited[nx][ny]){ // else로 빼니까 안됌-> visited 조건이 없으므로 방문한 곳 또 방문할 수 있음
                    q.add(new Point(nx, ny, p.count));
                    visited[nx][ny] = true;
                }
            }
        }

        return 0;
    }
}

class Point implements Comparable<Point>{
    int x, y, count;
    public Point(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
    @Override
    public int compareTo(Point other) {
        return Integer.compare(this.count, other.count);
    }
}