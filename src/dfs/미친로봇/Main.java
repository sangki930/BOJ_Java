package dfs.미친로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static double e,w,s,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1])/100.0;
        w = Integer.parseInt(input[2])/100.0;
        s = Integer.parseInt(input[3])/100.0;
        n = Integer.parseInt(input[4])/100.0;

        br.close();
    }
}
