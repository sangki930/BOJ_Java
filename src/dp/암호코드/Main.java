package dp.암호코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();
        int[] dp = new int[5001];
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] += dp[i-1];
            int a = Integer.parseInt(s.substring(i-2,i));
        }

        // 11~19, 20~26

        br.close();
    }
}
