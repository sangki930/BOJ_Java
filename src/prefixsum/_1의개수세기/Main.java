package prefixsum._1의개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);

        System.out.println(getCnt(b)-getCnt(a-1));

        br.close();
    }

    public static long getCnt(long n){
        long div = 1;
        long sum = 0;
        while(n>=div){
            long zero_range_min = 0;
            long zero_range_max = div-1;
            long one_range_min = div;
            long one_range_max = div*2-1;
            long mod = n%(div*2); // 나머지
            long t = n/(div*2); //몫

            if(zero_range_min<=mod && mod<=zero_range_max){
                sum += div*t;
            }else if(one_range_min<=mod && mod<=one_range_max){
                sum += div*t + (mod-zero_range_max);
            }
            div*=2;
        }
        return sum;
    }
}
