package implementation.카드섞기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] origin = p.clone();
        int[] g = new int[n];
        for(int i=0;i<n;i++){
            g[i] = (i%3);
        }
        int[] m = new int[n];
        int cnt = 0;

        while(!Arrays.equals(p,g)){
            for(int i=0;i<n;i++){
                m[s[i]] = p[i];
            }
            p = m;
            m = new int[n];
            cnt++;
            if(Arrays.equals(origin,p)){
                cnt = -1;
                break;
            }

        }
        System.out.println(cnt);
        br.close();
    }
}
