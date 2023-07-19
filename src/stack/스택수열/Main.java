package stack.스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int p = 1;
        StringBuffer sb = new StringBuffer();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            arr[i] = m;
        }
        int j=0;
        for(int i=1;i<=n;i++){
            if(i==arr[j]){
                stack.push(i);
                sb.append("+\n");
                int k = i;
                while(!stack.isEmpty() && stack.peek()==arr[j]){
                    stack.pop();
                    sb.append("-\n");j++;
                }
            }else{
                stack.push(i);
                sb.append("+\n");
            }
        }
        if(!stack.isEmpty())
            System.out.println("NO");
        else
            System.out.println(sb);

        br.close();
    }
}
