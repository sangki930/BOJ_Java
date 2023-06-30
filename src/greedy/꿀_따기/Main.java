package greedy.꿀_따기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] acc = new int[n];
        int[] acc_rev = new int[n];
        acc[0] = arr[0];
        for(int i=1;i<n;i++){
            acc[i] = acc[i-1]+arr[i];
        }
        acc_rev[n-1] = arr[n-1];
        for(int i=n-1;i>=1;i--){
            acc_rev[i-1] = acc_rev[i]+arr[i-1];
        }
        int sum=acc[n-1];
        int answer = acc_rev[0]-arr[0];
       // System.out.println(Arrays.toString(acc_rev));
        for(int i=1;i<n;i++){
            answer = Math.max(answer,acc_rev[0]-arr[0]-arr[i]+acc_rev[i]-arr[i]);
            //.out.println(answer);
        }
        //System.out.println(answer);
        for(int i=1;i<n-1;i++){
            answer = Math.max(answer,acc[i]+acc_rev[i]-arr[0]-arr[n-1]);
        }
        //System.out.println(answer);
        for(int i=n-2;i>=1;i--){
            answer = Math.max(answer,acc[n-1]-arr[n-1]+acc[i]-2*arr[i]);
        }

        System.out.println(answer);

        br.close();
    }
}
