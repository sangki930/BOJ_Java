package twopointer.수들의합5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int i = 1, j = 1;
        int sum = 1;
        int answer = 0;
        while (i <= j && j <= n) {

            if(sum <= n){
                if(sum==n) answer++;
                j++;
                sum += j;
            }else{
                sum -= i;
                i++;
            }
        }
        System.out.println(answer);

        br.close();
    }
}
