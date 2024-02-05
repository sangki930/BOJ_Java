package bruteforce.카드정리01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = -1;

        boolean used[] = new boolean[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            int idx = -1;
            for (int j = 0; j < m; j++) {
                if (!"0".equals(st.nextToken())) {
                    cnt++;
                    idx = j;
                }
            }

            if (cnt == 1 && !used[idx]) used[idx] = true;
            else if(cnt != 0) ans++;
        }

        System.out.println(Math.max(ans, 0));
    }

}
