package dijkstra.숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);

        int[] dis = new int[100001];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[n] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(n);
        while(!pq.isEmpty()){
            int loc = pq.poll();
            if(validation(loc+1) && dis[loc+1]>dis[loc]+1){
                dis[loc+1] = dis[loc]+1;
                pq.offer(loc+1);
            }

            if(validation(loc-1) && dis[loc-1]>dis[loc]+1){
                dis[loc-1] = dis[loc]+1;
                pq.offer(loc-1);
            }

            if(validation(loc*2) && dis[loc*2]>dis[loc]){
                dis[loc*2] = dis[loc];
                pq.offer(loc*2);
            }
        }
        System.out.println(dis[k]);
        br.close();
    }

    public static boolean validation(int loc){
        if(0<= loc && loc <100001) return true;
        return false;
    }
}
