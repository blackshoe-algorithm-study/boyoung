package week24_1029;

import java.io.*;
import java.util.*;

public class 색종이_만들기 {
    static int n;
    static int[][] paper;
    static int blue=0;
    static int white=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, n);

        System.out.println(white + "\n" + blue);
    }
    static void dfs(int x, int y, int size){
        if(size==0) return;

        int color = findSameColor(x, y, size);
        if(color==1){
            blue += 1;
        }else if(color==0){
            white += 1;
        }else{
            dfs(x, y, size / 2);
            dfs(x, y + size / 2, size / 2);
            dfs(x + size / 2, y, size / 2);
            dfs(x + size / 2, y + size / 2, size / 2);
        }
    }

    static int findSameColor(int x, int y, int size){
        int firstColor = paper[x][y];

        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(paper[i][j] != firstColor){
                    return -1;
                }
            }
        }

        return firstColor;
    }
}
