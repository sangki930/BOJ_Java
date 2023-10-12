package stack.단어뒤집기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='<'){
                while(!stack.isEmpty()) sb.append(stack.pop());
                queue.offer(c);
            }else if(c=='>'){
                while(!queue.isEmpty()){
                    sb.append(queue.pollFirst());
                }
                sb.append('>');
            }else if(c==' '){
                if(!queue.isEmpty()){
                    queue.offer(c);
                }else{
                    while (!stack.isEmpty()) sb.append(stack.pop());
                    sb.append(' ');
                }
            }
            else{
                if(!queue.isEmpty()){
                    queue.offer(c);
                }else{
                    stack.push(c);
                }
            }

        }
        while(!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb);
        br.close();
    }
}
