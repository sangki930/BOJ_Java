package prefixsum.인간_컴퓨터상호작용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();

        int[][] cnt = new int[ch.length][26];
        int[][] acc = new int[ch.length][26];

        for(int i=0;i<ch.length;i++){
            cnt[i][ch[i]-'a']++;
        }
        for(int i=0;i<26;i++){
            acc[0][i] = cnt[0][i];
        }
        for(int i=1;i<ch.length;i++){
            for(int j=0;j<26;j++){
                acc[i][j] = acc[i-1][j]+cnt[i][j];
            }
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            char c = input[0].charAt(0);
            int s = Integer.parseInt(input[1]);
            int e = Integer.parseInt(input[2]);
            sb.append(acc[e][c-'a'] - (s==0?0:acc[s-1][c-'a'])).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
