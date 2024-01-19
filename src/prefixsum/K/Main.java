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
        int[] acc = new int[n+1];
        for(int i=0;i<arr.length;i++){
            acc[i] = acc[i-1]+arr[i-1];
        }

        for(int i=0;i<arr.length;i++){

        }

        br.close();
    }
}
