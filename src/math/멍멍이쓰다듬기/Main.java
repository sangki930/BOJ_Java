package math.멍멍이쓰다듬기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]);

        br.close();
    }
}
