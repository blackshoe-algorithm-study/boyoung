package week20_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int h, w;
    static char[][] map;
    static Queue<Position> person;
    static Queue<Position> fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            person = new LinkedList<>();
            fire = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = str.charAt(j);
                    map[i][j] = c;
                    if (c == '@') person.add(new Position(i, j));
                    if (c == '*') fire.add(new Position(i, j));
                }
            }

            // 사람의 BFS 시작
            int result = bfs();
            if (result == -1) {
                sb.append("IMPOSSIBLE").append('\n');
            } else {
                sb.append(result).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    // 불과 사람을 동시에 움직이면서 BFS
    public static int bfs() {
        boolean[][] visitedPerson = new boolean[h][w]; // 사람의 방문 여부
        visitedPerson[person.peek().x][person.peek().y] = true;

        int time = 0;  // 이동한 시간

        while (!person.isEmpty()) {
            int fireSize = fire.size();
            // 불이 번짐
            for (int i = 0; i < fireSize; i++) {
                Position firePos = fire.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = firePos.x + dx[d];
                    int ny = firePos.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;  // 범위 체크
                    if (map[nx][ny] == '.' || map[nx][ny] == '@') {  // 불이 번질 수 있는 곳
                        fire.add(new Position(nx, ny));
                        map[nx][ny] = '*';  // 불 번짐 표시
                    }
                }
            }

            int personSize = person.size();
            // 사람이 이동
            for (int i = 0; i < personSize; i++) {
                Position personPos = person.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = personPos.x + dx[d];
                    int ny = personPos.y + dy[d];

                    // 탈출 성공
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        return time + 1;  // 탈출할 때까지의 시간을 리턴
                    }

                    // 이동할 수 있는 경우 -> queue에 담는 것이지 실제 이동한 것이 아니기 때문에 count 하지 않음
                    if (map[nx][ny] == '.' && !visitedPerson[nx][ny]) {
                        person.add(new Position(nx, ny));
                        visitedPerson[nx][ny] = true;  // 방문 체크
                    }
                }
            }
            time++;
        }

        return -1;  // 탈출할 수 없는 경우
    }
}

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


// package week20_0910;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.StringTokenizer;

// public class 불 {
//     static int N;
//     static int[] dx ={-1,1,0,0};
//     static int[] dy ={0,0,-1,1};
//     static int h,w;
//     static char[][] map;
//     static Queue<Position> person;
//     static Queue<Position> fire;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         N = Integer.parseInt(br.readLine());
//         StringTokenizer st;

//         while(N-- > 0){
//             st = new StringTokenizer(br.readLine());
//             w = Integer.parseInt(st.nextToken());
//             h = Integer.parseInt(st.nextToken());
//             map = new char[w][h];
//             person = new LinkedList<>();
//             fire = new LinkedList<>();

//             for(int i=0; i<h; i++){
//                 String str = br.readLine();
//                 for(int j=0; j<w; j++){
//                     char c = str.charAt(j);
//                     map[i][j]=c;
//                     if(c=='@') person.add(new Position(i, j));
//                     if(c=='*') fire.add(new Position(i, j));
//                 }
//             }

//             // 불 번지는 bfs
//             Position position = fire.poll();
//             firebfs(position.x, position.y);
//             // 나갈 길 찾는 bfs
//             Position position2 = person.poll();
//             if(personbfs(position2.x, position2.y, 0) > 0){
//                 System.out.println(personbfs(position2.x, position2.y, 0));
//             }else{
//                 System.out.println("IMPOSSIBLE");
//             }
//         }
//     }
//     public static void firebfs(int x, int y){
//         fire.add(new Position(x, y));

//         while(!fire.isEmpty()){
//             Position position = fire.poll();
//             for(int i=0; i<4; i++){
//                 int nx = position.x + dx[i];
//                 int ny = position.y + dy[i];

//                 if(nx<0 || ny<0 || nx>=h || ny>=w) continue;
//                 if(map[nx][ny]=='#' || map[nx][ny]=='@') continue; 
//                 if(map[nx][ny]=='.'){
//                     fire.add(new Position(nx, ny));
//                     map[nx][ny]='*';
//                 }
//             }
//         }
//     }

//     public static int personbfs(int x, int y, int count){
//         person.add(new Position(x, y));

//         while(!person.isEmpty()){
//             Position position = person.poll();
//             for(int i=0; i<4; i++){
//                 int nx = position.x + dx[i];
//                 int ny = position.y + dy[i];

//                 if(nx<0 || ny<0 || nx>=h || ny>=w) return count+1;
//                 if(map[nx][ny]=='#' || map[nx][ny]=='*') continue;

//                 if(map[nx][ny]=='.'){
//                     person.add(new Position(nx, ny));
//                     map[nx][ny]='@';
//                     map[x][y]='.';
//                 }
//             }
//             count++;
//         }

//         return -1;
//     }
// }
// class Position{
//     int x,y;
//     public Position(int x, int y){
//         this.x=x;
//         this.y=y;
//     }
// }