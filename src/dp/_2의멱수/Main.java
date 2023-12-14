package dp._2의멱수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        // 1 : 1
        // 2 : 2, 1+1
        // 3 : 1+2, 1+1+1
        // 4 : 4, 2+2, 1+1+2, 1+1+1+1
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<dp.length;i++){
            if(i%2==0){
                dp[i] = (dp[i-1]+dp[i/2])%1000000000;
            }else{
                dp[i] = dp[i-1];
            }
        }
        System.out.println(dp[n]);
        br.close();
    }
}
