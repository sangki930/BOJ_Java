package math.개미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]), h = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]), q = Integer.parseInt(input[1]);

        int t = Integer.parseInt(br.readLine());

        // 개미가 이동한 거리 - 왕복한 거리
        int a = (p + t) / w;
        int b = (q + t) / h;
        int x = a%2==0? (p+t)%w:(w - (p + t) % w);
        int y = b%2==0? (q+t)%h:(h - (q + t) % h);

        System.out.println(x+" "+y);

        br.close();
    }
}
