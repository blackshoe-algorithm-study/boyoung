package week25_1105;

import java.io.*;
import java.util.*;

public class 딸기와_토마토 {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 연속 칸의 개수
        int[][] map = new int[N][M];
        int seed = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    seed++;
                }
            }
        }

        // 하나도 안 겹치는 경우
        if (2 * K == seed) {
            System.out.println(0);
            return;
        }

        // 하나만 겹치는 경우
        if (2 * K - 1 == seed) {
            Position position = oneCheck(map, N, M);
            System.out.println(1);
            System.out.println(position.x + " " + position.y);
            return;
        }

        // 두 개 이상 겹치는 경우
        ArrayList<Position> positions = oneMoreCheck(map, N, M, K);
        System.out.println(positions.size());
        for (Position pos : positions) {
            System.out.println(pos.x + " " + pos.y);
        }
    }

    static ArrayList<Position> oneMoreCheck(int[][] map, int N, int M, int K) {
        ArrayList<Position> positions = new ArrayList<>();
        HashSet<String> uniquePositions = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                
                // 가로 방향 확인
                int horizontalCount = 1;
                for (int x = j + 1; x < M && x < j + K; x++) {
                    if (map[i][x] == 1) {
                        horizontalCount++;
                    } else {
                        break;
                    }
                }

                if (horizontalCount >= K) {
                    for (int x = j; x < j + horizontalCount; x++) {
                        String pos = (i + 1) + "," + (x + 1);
                        if (!uniquePositions.contains(pos)) {
                            positions.add(new Position(i + 1, x + 1, horizontalCount));
                            uniquePositions.add(pos);
                        }
                    }
                }

                // 세로 방향 확인
                int verticalCount = 1;
                for (int y = i + 1; y < N && y < i + K; y++) {
                    if (map[y][j] == 1) {
                        verticalCount++;
                    } else {
                        break;
                    }
                }

                if (verticalCount >= K) {
                    for (int y = i; y < i + verticalCount; y++) {
                        String pos = (y + 1) + "," + (j + 1);
                        if (!uniquePositions.contains(pos)) {
                            positions.add(new Position(y + 1, j + 1, verticalCount));
                            uniquePositions.add(pos);
                        }
                    }
                }
            }
        }
        return positions;
    }

    static Position oneCheck(int[][] map, int N, int M) {
        int[] dx = {1, -1};
        int[] dy = {1, -1};
        
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 0) {
                    continue;
                }
    
                boolean checkX = false;
                boolean checkY = false;
    
                for (int i = 0; i < 2; i++) {
                    int nx = x + dx[i];
                    if (nx >= 0 && nx < M && map[y][nx] == 1) {
                        checkX = true;
                    }
    
                    int ny = y + dy[i];
                    if (ny >= 0 && ny < N && map[ny][x] == 1) {
                        checkY = true;
                    }
                }
    
                if (checkX && checkY) {
                    return new Position(y + 1, x + 1, 2);
                }
            }
        }
        return new Position(-1, -1, 0);
    }
    

    static class Position {
        int x;
        int y;
        int count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
