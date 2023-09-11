package dp.파이프옮기기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for(int i=0;i<n;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][][] dp = new int[n][n][3];
        dp[0][1][0] = 1; // 0 : 가로, 1 : 세로, 2 : 대각선
        for(int i=2;i<n;i++){
            if(map[0][i] == 0)
                dp[0][i][0] = dp[0][i-1][0];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(map[i][j] == 0 && map[i][j-1] == 0 && map[i-1][j] == 0){
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1]+dp[i-1][j-1][2];
                }
                if(map[i][j] == 0){
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                }
            }
        }

        System.out.println(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2]);

        br.close();
    }
}
