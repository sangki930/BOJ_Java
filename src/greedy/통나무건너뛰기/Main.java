package greedy.통나무건너뛰기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);
            LinkedList<Integer> deque = new LinkedList<>();
            deque.offer(arr[n-1]);
            int answer = 0;
            for(int j=n-2;j>=0;j--){
                if(j%2==1){
                    answer = Math.max(Math.abs(arr[j]-deque.peekFirst()),answer);
                    deque.offerFirst(arr[j]);
                }else{
                    answer = Math.max(Math.abs(arr[j]-deque.peekLast()),answer);
                    deque.offerLast(arr[j]);
                }
            }
            System.out.println(Math.max(answer,Math.abs(deque.peekFirst()-deque.peekLast())));
        }

        br.close();
    }
}
