package twopointer.수고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long m = Long.parseLong(input[1]);
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int i=0,j=0;
        long diff = Long.MAX_VALUE;
        while(i<=j && j<n){
            long tmp = Math.abs(arr[i]-arr[j]);
            if(tmp>=m){
                if(tmp<=diff){
                    diff = tmp;
                }
                i++;
            }else{
                j++;
            }
        }

        System.out.println(diff);

        br.close();
    }
}
