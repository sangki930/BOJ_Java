package dp.무한수열2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static long n,p,q,x,y;
    static Map<Long,Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Long.parseLong(input[0]);
        p = Long.parseLong(input[1]);
        q = Long.parseLong(input[2]);
        x = Long.parseLong(input[3]);
        y = Long.parseLong(input[4]);

        map.put(0L,1L);
        System.out.println(func(n));
        br.close();
    }

    public static long func(long i){
        if(i<=0){
            return 1L;
        }
        if(map.containsKey(i)){
            return map.get(i);
        }

        long result  = func(i/p-x)+func(i/q-y);
        map.put(i,result);
        return result;
    }
}
