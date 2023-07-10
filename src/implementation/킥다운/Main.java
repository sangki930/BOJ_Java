package implementation.킥다운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 킥다운
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] top = new int[200];
        String[] input = br.readLine().split("");
        int top_len = input.length;
        for(int i=0;i< input.length;i++){
            top[i] = Integer.parseInt(input[i]);
        }
        int[] bottom = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int answer = 200;
        for(int i=0;i<top_len;i++){
            int[] cl = top.clone();
            int max = -1;
            for(int j=0;j<bottom.length;j++){
                cl[i+j]+=bottom[j];
                max = Math.max(max,cl[i+j]);
            }
            System.out.println(Arrays.toString(cl));
            if(max<=3){
                int len = 0;
                for(len=0;len<cl.length;len++){
                    if(cl[len]==0) break;
                }
                answer = Math.min(answer,len);
            }
        }
        System.out.println(answer);
        br.close();
    }
}
