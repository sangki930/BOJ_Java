package math.암호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static long mod = 900528;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character,Long> map = new HashMap<>();

        String s = br.readLine();
        String t = br.readLine();
        int len = s.length();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,Math.min(map.getOrDefault(c,Long.MAX_VALUE),i+1));
        }
        long answer = 0;
        for(int i=t.length()-1,j=0;i>=0;i--,j++){
            char c = t.charAt(i);
            long idx = map.getOrDefault(c,-1L);
            if(idx != -1){
                answer += modMultExp(idx,len,j,900528);
            }
        }
        System.out.println(answer%mod);

        br.close();
    }

    // 모듈러 거듭제곱 함수
    public static long modExp(long a, long p, long mod) {
        long result = 1;
        long base = a % mod;

        while (p > 0) {
            if (p % 2 == 1) {  // p가 홀수인 경우
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            p = p / 2;  // p를 반으로 나눠서 다음 루프 수행
        }

        return result;
    }

    // b * (a^p) % mod를 계산하는 함수
    public static long modMultExp(long b, long a, long p, long mod) {
        // 먼저 a^p % mod 계산
        long a_p_mod = modExp(a, p, mod);

        // 그 결과를 b와 곱하고, 다시 mod로 나눔
        long result = (b * a_p_mod) % mod;

        return result;
    }
}
