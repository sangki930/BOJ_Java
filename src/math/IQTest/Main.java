package math.IQTest;

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
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        if(n<=2) {
            if (n == 1) {
                System.out.println("A");
            } else if (n == 2) {
                if (arr[0] == arr[1]) {
                    System.out.println(arr[0]);
                } else
                    System.out.println("A");
            }
        }
        else if(n>2){
            long tmp = arr[1] - arr[0];
            long tmp2 = arr[2] - arr[1];
            long a = 0;
            if(tmp!=0) a = tmp2/tmp;
            long b = arr[1] - a*arr[0];
            for(int i=2;i<n;i++){
                if(arr[i]!=arr[i-1]*a+b){
                    System.out.println("B");
                    return ;
                }
            }
            System.out.println(arr[n-1]*a+b);
        }


        br.close();
    }
}
