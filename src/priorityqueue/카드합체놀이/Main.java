package priorityqueue.카드합체놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Arrays.stream(br.readLine().split(" ")).forEach(i->pq.offer(Long.parseLong(i)));

        for(int i=0;i<m;i++){
            long a = pq.poll();
            long b = pq.poll();
            pq.offer(a+b);
            pq.offer(a+b);
        }

        long answer = 0;
        while(!pq.isEmpty()) answer+= pq.poll();
        System.out.println(answer);
        br.close();
    }
}
