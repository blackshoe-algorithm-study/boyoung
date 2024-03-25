package week2_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws IOException{
        //"("인 경우는 stack에 push
        //")"인 경우는 stack에서 pop
        //stack이 비었는데 ")"가 오는 경우 "NO"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            String str = br.readLine();
            sb.append(solve(str)).append('\n');
        }
        System.out.println(sb);

    }

    public static String solve(String str){
        Stack<Character> stack = new Stack<>();

        for(int j=0; j<str.length(); j++){
            if(str.charAt(j)=='('){ // ""->String, ''->char
                stack.push(str.charAt(j));
            }
            else if(stack.isEmpty()){
                return "No";
            }
            else{
                stack.pop();
            }
        }

        if(stack.isEmpty()){
            return "Yes";
        }
        else{
            return "No";
        }
    }
}
