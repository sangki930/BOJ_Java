package math._4와7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        System.out.println(Integer.toBinaryString(k+1).substring(1).replaceAll("0","4").replaceAll("1","7"));

        br.close();
    }
}
