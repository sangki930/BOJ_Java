package prefixsum._1의개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        // 1 10 11 100 101 110 111 1000 1001 1010 1011
        // 1 1 2 1 2 3 1 2 2 3

        br.close();
    }
}
