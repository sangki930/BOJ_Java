package priorityqueue.최솟값찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), l = Integer.parseInt(input[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        input = br.readLine().split(" ");
        pq.offer(Integer.parseInt(input[0]));
        for(int i=1;i<n;i++){
            
        }

        br.close();
    }
}
