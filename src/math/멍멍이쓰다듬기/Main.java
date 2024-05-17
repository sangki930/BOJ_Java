package math.멍멍이쓰다듬기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]);
        long diff = y-x;
        long day = 0;
        loop : for(long i=1;i< Math.pow(2,31) ;i++){
            for(int j=0;j<2;j++){
                if(diff<=0L) {
                    break loop;
                }
                day++;
                diff -=i;
            }
        }
        System.out.println(day);
        br.close();
    }
}
