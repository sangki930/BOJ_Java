package math.알_수_없는_번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]), b = Long.parseLong(input[1]);
        input = br.readLine().split(" ");
        long x = Long.parseLong(input[0]), y = Long.parseLong(input[1]);

        if(a==b){
            System.out.println(a);
            return ;
        }else if(a<b){

            b = (long)Math.floor((b-y)*1.0/x);
            a = (long)Math.ceil((a-y)*1.0/x);
        }else if(a>b){
            long tmp = b;
            b = (long)Math.floor((a-y)*1.0/x);
            a = (long)Math.ceil((tmp-y)*1.0/x);
        }

        // a-y b-y
        long cnt = b-a+1;

        if(cnt>=2){
            System.out.println("Unknwon Number");
        }else{
            System.out.println(a*x+y);
        }
        br.close();
    }
}
