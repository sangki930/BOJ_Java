package sort.두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);
        int left = 0, right = arr.length-1;
        int a = 0, b = 0;
        //System.out.println(Arrays.toString(arr));
        int v = Integer.MAX_VALUE;
        while(left<right){
            int s = arr[left]+arr[right];

            if(v>Math.abs(s)){
                v = Math.abs(s);
                a = arr[left];
                b = arr[right];
                if(s==0) break;
            }

            if(s<0) left++;
            else right--;
        }
        System.out.println(a+" "+b);

        br.close();
    }
}
