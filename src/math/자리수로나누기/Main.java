package math.자리수로나누기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        set = String.valueOf(n)
                .chars()
                .filter(c -> c != '0')
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toSet());
        if(is_dividable(n)){
            System.out.println(n);
        }else
            loop : for(int i=0;i<=7;i++){
                for(int j=0;j<(int)Math.pow(10,i)-1;j++){
                    long tmp = Long.parseLong(n+""+ String.format("%0"+i+"d",j) );
                    if(is_dividable(tmp)){
                        System.out.println(tmp);
                        break loop;
                    }
                }
            }

        br.close();
    }

    public static boolean is_dividable(long n){
        for(int i : set){
            if(n % i !=0) return false;
        }
        return true;
    }

}
