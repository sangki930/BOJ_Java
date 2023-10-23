package math.등차수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        switch (k){
            case 2->{
                System.out.println(Math.max(r, 2) - Math.max(2, l-1));
            }
            case 3->{
                System.out.println(Math.max(r, 5)/3 - Math.max(5, l-1)/3+ "");
            }
            case 5->{
                System.out.println(Math.max(r, 14)/5 - Math.max(14, l-1)/5+ "");
            }
            default -> {
                int temp = Math.max(r, 9)/2 - Math.max(9, l-1)/2;
                if (l <= 12 && 12 <= r) { temp--; }
                System.out.println(temp + "");
            }
        }

        br.close();
    }
}
