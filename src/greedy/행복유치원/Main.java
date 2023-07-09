package greedy.행복유치원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] diff = new int[n-1];
        for(int i=0;i<n-1;i++){
            diff[i] = arr[i+1]-arr[i];
        }
        Arrays.sort(diff);
        long answer = 0;
        for(int i=0;i<n-k;i++)
            answer+=diff[i];
        System.out.println(answer);
        br.close();
    }
}
