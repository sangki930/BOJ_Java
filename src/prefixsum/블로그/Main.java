package prefixsum.블로그;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long sum = 0, answer = 0;
        for(int i=0;i<x;i++){
            sum += arr[i];
        }
        answer = sum;
        Map<Long,Integer> counter = new HashMap<>();
        counter.put(sum,1);
        for(int i=x;i<n;i++){
            sum = sum + arr[i]-arr[i-x];
            counter.put(sum,counter.getOrDefault(sum,0)+1);
            answer = Math.max(answer,sum);
        }
        if(answer == 0){
            System.out.println("SAD");
            br.close();
            return;
        }
        System.out.println(answer);
        System.out.println(counter.get(answer));
        br.close();
    }

}
