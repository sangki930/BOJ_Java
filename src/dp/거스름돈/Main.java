package dp.거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        if(n>=2)
            dp[2] = 1;
        if(n>=5)
            dp[5] = 1;
        for (int i = 3; i < n + 1; i++) {
            if (dp[i - 2] != -1)
                dp[i] = dp[i - 2] + 1;
            if (i > 5 && dp[i - 5] != -1)
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
        }
        System.out.println(dp[n]);

        br.close();
    }
}
