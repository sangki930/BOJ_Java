package sweeping.흙길보수하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Puddle{
    int s,e;
    public Puddle(int s, int e){
        this.s=s;
        this.e=e;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), l =Integer.parseInt(input[1]);

        for(int i=0;i<n;i++){

        }

        br.close();
    }
}
