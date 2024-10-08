package week22_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
    static int N;
    static int[][] image;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        image = new int[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                image[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(quadTree(0, 0, N));

    }

    public static String quadTree(int x, int y, int size){
        if(sameColor(x, y, size)){
            return String.valueOf(image[x][y]);
        }

        String topLeft = quadTree(x, y, size / 2);
        String topRight = quadTree(x, y + size / 2, size / 2);
        String bottomLeft = quadTree(x + size / 2, y, size / 2);
        String bottomRight = quadTree(x + size / 2, y + size / 2, size / 2);

        return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
    }

    public static boolean sameColor(int x, int y, int size){
        int color = image[x][y];

        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(image[i][j]!=color) return false;
            }
        }

        return true;

    }
}
