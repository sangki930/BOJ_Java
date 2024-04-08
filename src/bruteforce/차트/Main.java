package bruteforce.차트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, ans;
    public static int[] a = new int[8], buf = new int[8];
    public static boolean[] vt = new boolean[8];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        brute(0);
        System.out.println(ans);
    }

    public static int calc() {
        int[] tmp = new int[16];
        int cnt = 0;
        for (int i = 0 ; i < N ; i++) {
            tmp[i] = a[buf[i]];
            tmp[i + N] = tmp[i];
        }
        for (int i = 0 ; i < N ; i++) {
            int sum = 0;
            for (int j = i ; sum < 50 ; j++) {
                sum += tmp[j];
            }
            if (sum == 50) cnt++;
        }
        return cnt / 2;
    }
    public static void brute(int k) {
        if (k == N) {
            int tmp = calc();
            if (ans < tmp) ans = tmp;
            return;
        }
        for (int i = 0 ; i < N ; i++) {
            if (vt[i]) continue;
            vt[i] = true;
            buf[k] = i;
            brute(k + 1);
            vt[i] = false;
        }
    }
}
