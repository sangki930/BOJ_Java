package math.다이어트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=g;i++){
            int j = g/i;
            if(i*j == g){
                double a = (i+j)/2.0;
                double b = (i-j)/2.0;
                if(a>=1 && a==(int)a && b>=1 && b==(int)b){
                    if(a>=b){
                        list.add((int)a);
                    }
                }
            }
        }
        if(list.isEmpty())
            System.out.println("-1");
        else
            for(int i : list)
                System.out.println(i);

        br.close();
    }
}
