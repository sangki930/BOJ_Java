package greedy.전구와스위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] goal = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int answer=0;
        for(int i=0;i<n;i++){
                if(arr[i]==goal[i]){
                    for(int j=Math.max(0,i-1);j<=Math.min(n-1,i+1);j++){
                        arr[j]=arr[j]==0?1:0;
                    }

                    answer++;
                }
            System.out.println(Arrays.toString(arr));
        }
        if(!Arrays.equals(arr,goal)) answer = -1;
        System.out.println(answer);
        br.close();
    }
}
