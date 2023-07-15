package stack.PPAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
            if(stack.size()>=4){
                String res = "";
                for(int j=0;j<4;j++){
                    res = stack.pop()+res;
                }
                if(res.equals("PPAP")) stack.push('P');
                else{
                    for(int j=0;j<4;j++){
                        stack.push(res.charAt(j));
                    }
                }
            }
//            System.out.println(stack);
        }

        if(stack.size()==1 && stack.peek()=='P')
            System.out.println("PPAP");
        else
            System.out.println("NP");

        br.close();
    }
}
