package dp.암호코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] dp = new int[str.length()+1];
        dp[0] = 1;

        for(int i=1; i<=str.length(); i++) {
            int now = str.charAt(i-1) - '0';
            if(now >= 1 && now <= 9) {
                dp[i] += dp[i-1];
                dp[i] %= 1000000;
            }

            if(i == 1) continue; //첫번째 글자일 경우

            int prev = str.charAt(i-2) - '0';

            if(prev == 0) continue; //0으로 시작할경우 존재 X

            int value = prev*10+now;

            if(value >= 10 && value <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= 1000000;
            }
        }
        System.out.println(dp[str.length()]);

        br.close();
    }
}
