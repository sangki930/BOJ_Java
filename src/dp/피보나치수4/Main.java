package dp.피보나치수4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] dp = new long[10005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(f(n));
        br.close();
    }

    public static long f(int n){
        if(n<=1) return dp[n]=n;
        if(dp[n]>0) return dp[n];
        return dp[n] = f(n-1)+f(n-2);
    }
}
