package dijkstra.숨바꼭질4;

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
        int[] parents = new int[100001];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Arrays.fill(parents,-1);
        dis[n] = 0;

        parents[n] = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(n);
        while(!pq.isEmpty()){
            int loc = pq.poll();
            if(validation(loc+1) && dis[loc+1]>dis[loc]+1){
                dis[loc+1] = dis[loc]+1;
                parents[loc+1] = loc;
                pq.offer(loc+1);
            }

            if(validation(loc-1) && dis[loc-1]>dis[loc]+1){
                dis[loc-1] = dis[loc]+1;
                parents[loc-1] = loc;
                pq.offer(loc-1);
            }

            if(validation(loc*2) && dis[loc*2]>dis[loc]+1){
                dis[loc*2] = dis[loc]+1;
                parents[loc*2] = loc;
                pq.offer(loc*2);
            }
        }
        System.out.println(dis[k]);
        StringBuilder sb = new StringBuilder(k+"");
        while(parents[k]!=-1){
            k = parents[k];
            sb.insert(0,k+" ");
        }
        System.out.print(sb);

        br.close();
    }

    public static boolean validation(int loc){
        if(0<= loc && loc <100001) return true;
        return false;
    }
}
