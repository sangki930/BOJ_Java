package prefixsum.K;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] acc = new long[n+1];
        int l = 0;
        long min = Long.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            acc[i+1] = acc[i]+arr[i];
        }

        for (int k = 1; k <= n / 2; k++) {
            for (int j = k; j <= n; j++) {
                for (int i = j+k; i<=n; i++) {
                    long sub = Math.abs((acc[j] - acc[j - k]) - (acc[i] - acc[i - k]));
                    if (sub <= min) {
                        min = sub;
                        l = k;
                    }
                }
            }
        }

        System.out.println(l);
        System.out.println(min);

        br.close();
    }
}
