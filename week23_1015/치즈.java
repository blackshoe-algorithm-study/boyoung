package week23_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 치즈 {
    static int N, M;
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0; 
        while (true) {
            visited = new boolean[N][M];
            dfs(0, 0);
            
            boolean melted = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (cheese[i][j] == 1) {
                        if (isMelt(i, j)) { 
                            cheese[i][j] = 0;
                            melted = true;
                        }
                    }
                }
            }

            if (!melted) {
                break;
            }
            time++;
        }

        System.out.println(time);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (!visited[nx][ny] && cheese[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }

    static boolean isMelt(int x, int y) {
        boolean check = false;
        int contact = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (cheese[nx][ny] == 0 && visited[nx][ny]) {  
                contact++;
            }
        }

        if(contact >= 2){
            check = true;
        }

        return check; 
    }
}


// package week23_1015;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class 치즈 {
//     static int N,M;
//     static int[][] cheese;
//     static boolean[][] visited;
//     static int[] dx = {-1,1,0,0};
//     static int[] dy = {0,0,-1,1};
//     public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        visited = new boolean[N][M];

//        for(int i=0; i<N; i++){
//         st = new StringTokenizer(br.readLine());
//         for(int  j=0; j<M; j++){
//             cheese[i][j] = Integer.parseInt(st.nextToken());
//         }
//        }

//        int count=0;

//        for(int i=0; i<N; i++){
//         for(int j=0; j<M; j++){
//             if(!visited[i][j]){
//                 dfs(0, 0);
//                 count++;
//             }
//         }
//        }



//     }
//     static void dfs(int x, int y){
//         visited[x][y] = true;
//         int count=0;

//         for(int i=0; i<4; i++){
//             int nx = x + dx[i];
//             int ny = y + dy[i];

//             if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

//             if(!visited[nx][ny] && cheese[nx][ny] == 0){
//                 count++;
//             }
//         }

//         if(count>=2){
//             cheese[x][y]=0;
//         }
//     }
// }

// //solution for 모든 점 탐색
// //dfs에서 4방향에서 count해서 2방향에서 인접한게0이면 0으로 바꿔주기