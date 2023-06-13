package implementation.카드바꾸기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(i->Double.parseDouble(i)).toArray();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                double d = (arr[j]-arr[i])/(j-i);
                if((int)Math.floor(d)==(int)d){
                   set.add((int)d);
                }
            }
        }
        System.out.println(set);
        int answer = Integer.MAX_VALUE;
        for(int diff : set){
            int cnt = 0;
            for(int i=0;i<arr.length;i++){
                if(diff*i*1.0+arr[0]==arr[i]){
                    cnt++;
                }
            }
            answer = Math.min(answer,cnt);
        }
        System.out.println(answer);

        br.close();
    }
}
