package math.사람의수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = IntStream.range(0, n)
                .map(i -> {
                    try {
                        return Integer.parseInt((br.readLine().split("\\.")[1]));
                    } catch (IOException e) {
                        return 0;
                    }
                })
                .toArray();
        int i = 1;
        loop : for(;;){
            boolean flag = true;
            for(int j=0;j<arr.length;j++){
                int tmp = i*arr[j];
                if(tmp%1000 !=0) tmp = tmp - (tmp%1000)+1000;
                int num = tmp/i;
                if(num != arr[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(i);
                break loop;
            }
            i++;
        }

        br.close();
    }
}