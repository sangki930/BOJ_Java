package math.머리톡톡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] cnts = new int[1000001];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            cnts[arr[i]]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=1;j<=(int)Math.sqrt(arr[i]);j++){
                if(arr[i]%j==0){
                    if(j*j == arr[i]){
                        cnt = cnt + cnts[j];
                    }else
                        cnt = cnt + cnts[j] + cnts[arr[i]/j];
                }
            }
            sb.append(--cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}