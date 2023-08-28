package dp.회의실배정4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] meetings;
    static int[] startingPoints;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        meetings = new int[N][3];
        startingPoints = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
            meetings[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meetings, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < N; i++) {
            startingPoints[i] = meetings[i][0];
        }
        startingPoints[N] = Integer.MAX_VALUE;

        int[] dp = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            int next = getNextStartingPoint(meetings[i][1]);
            dp[i] = Math.max(meetings[i][2] + dp[next], dp[i + 1]);
        }
        System.out.println(dp[0]);
    }

    static int getNextStartingPoint(int end) {
        int n = Arrays.binarySearch(startingPoints, end);
        if (n<0) {
            n = -n-1;
        }
        return n;
    }
}
