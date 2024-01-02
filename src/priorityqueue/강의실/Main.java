package priorityqueue.강의실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Range{
    int id; // 강의번호
    int s,e; // 강의 시작시간, 종료시간
    public Range(int id, int s, int e){
        this.s=s;
        this.e=e;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Range> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            String[] input = br.readLine().split(" ");
            int id = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]), e = Integer.parseInt(input[2]);
            list.add(new Range(id, s, e));
        }
        list.sort((o1,o2)->Integer.compare(o1.s,o2.s));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 1;
        for(int i=0;i<n;i++){
            Range r = list.get(i);
            while(!pq.isEmpty() && pq.peek()<=r.s){
                pq.poll();
            }
            pq.offer(r.e);
            answer = Math.max(pq.size(),answer);
        }
        System.out.println(answer);

        br.close();
    }
}
