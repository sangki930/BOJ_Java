package greedy.게임을_만든_동준이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long answer = 0;
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(br.readLine());
        for(int i=n-1;i>=1;i--){
            if(arr[i]<=arr[i-1]){
                answer+=(arr[i-1]-arr[i]+1);
                arr[i-1] = arr[i]-1;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
