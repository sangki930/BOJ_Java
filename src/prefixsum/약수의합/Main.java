package prefixsum.약수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int MAX = 1000000;
        long[] dp = new long[MAX+1];
        long[] s = new long[MAX+1];
        Arrays.fill(dp,1);
        for(int i=2;i<=MAX;i++){
            for(int j=1;i*j<=MAX;j++){
                dp[i*j]+=(long)i;
            }
        }
        for(int i=1;i<=MAX;i++){
            s[i] = s[i-1]+dp[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(s[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}
