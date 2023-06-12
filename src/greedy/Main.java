package greedy;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(input[i]);
        int now = 1, answer = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==now){
                now++;continue;
            }
            answer++;
        }
        System.out.println(answer);
        br.close();
    }
}