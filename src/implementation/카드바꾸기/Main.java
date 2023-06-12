package implementation.카드바꾸기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(i->Double.parseDouble(i)).toArray();
        for(int i=1;i<arr.length;i++){
            
        }

        br.close();
    }
}
