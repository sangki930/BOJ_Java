package stack.괄호의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(stack.peek() == '('){

                }else if(stack.peek() == '['){

                }else{

                }
            }
        }

        br.close();
    }
}
