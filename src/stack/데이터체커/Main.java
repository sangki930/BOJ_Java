package stack.데이터체커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n*2][];

        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]), r = Integer.parseInt(tmp[1]);
            arr[i] = new int[]{x-r,i};
            arr[i+n] = new int[]{x+r,i};
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<2*n;i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                if(stack.peek()[1]==arr[i][1]) {
                    stack.pop();
                }else stack.push(arr[i]);
            }
        }

        if(stack.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");

        br.close();
    }

}
