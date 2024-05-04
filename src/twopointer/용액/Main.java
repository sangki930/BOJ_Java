package twopointer.용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()), m=0;
        Long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).boxed().toArray(Long[]::new);
        Arrays.sort(arr,(a,b)->Long.compare(Math.abs(a),Math.abs(b)));
        int i=0,j=1;
        long diff = Long.MAX_VALUE;
        long answer1 = Long.MAX_VALUE, answer2 = Long.MAX_VALUE;
        while(i<=j && j<n){
            if(i==j){
                j++;
                continue;
            }
            long tmp = Math.abs(arr[i]+arr[j]);

            if(tmp<diff){
                diff = tmp;
                answer1 = Math.min(arr[i],arr[j]);
                answer2 = Math.max(arr[i],arr[j]);
                j++;
            }else{
                i++;
            }
        }

        System.out.println(answer1 + " " +answer2);

        br.close();
    }
}