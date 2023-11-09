package implementation.킥다운;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String gearA = br.readLine();
        String gearB = br.readLine();

        int sumlen = gearA.length() + gearB.length();
        int ans = gearA.length() + gearB.length();

        int ai = gearA.length() -1;
        int aj = gearA.length() -1;
        int bi = 0;
        int bj = 0;

        while (true) {

            boolean for_else = true;
            for (int i = 0; i < aj-ai + 1; i++) {
                char a = gearA.charAt(ai + i);
                char b = gearB.charAt(bi + i);
                if (a == b && b == '2') {
                    for_else = false;
                    break;
                }
            }

            if (for_else) {
                ans = Math.min(ans, sumlen - (aj-ai + 1));
            }

            ai -= 1;
            if (ai == -1) {
                ai = 0;
                bi += 1;
            }

            bj += 1;
            if (bj == gearB.length()) {
                bj = gearB.length() -1;
                aj -= 1;
            }

            if (ai > aj || bi > bj) {
                break;
            }
        }

        System.out.println(ans);

    }

}
