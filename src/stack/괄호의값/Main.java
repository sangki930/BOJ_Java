package stack.괄호의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        long[] arr = new long[31];
        int j = 1;
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                j++;
            }else{
                if(stack.peek() == '(' && s.charAt(i)==')'){
                    stack.pop();
                    if(arr[j]==0) arr[j]=1L;
                    arr[j-1] += arr[j]*2;
                    arr[j--] = 0;
                }else if(stack.peek() == '[' && s.charAt(i)==']'){
                    stack.pop();
                    if(arr[j]==0) arr[j]=1L;
                    arr[j-1] += arr[j]*3;
                    arr[j--] = 0;
                }else{
                    stack.push(s.charAt(i));
                    j++;
                }
            }
        }

        if(!stack.isEmpty()){
            System.out.println(0);
            br.close();
            return ;
        }
        System.out.println(arr[1]);
        br.close();
    }
}
