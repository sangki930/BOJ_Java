package stack.후위표기식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(c);
            }else if(c=='+' || c=='-'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }else if(c=='*' || c=='/'){
                while(!stack.isEmpty() && stack.peek()!='(' && (stack.peek()=='*' || stack.peek()=='/')){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                while (!stack.isEmpty() && stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else{
                sb.append(c);
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
        br.close();
    }
}
