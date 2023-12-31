package priorityqueue.강의실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        PriorityQueue<Range> pq = new PriorityQueue<>(
                (a,b)->{
                    if(a.s==b.s)
                        return Integer.compare(b.e,a.e);
                    return Integer.compare(a.s,b.s);
                }
        );

        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            int id = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            int e = Integer.parseInt(input[2]);
            pq.offer(new Range(id, s, e));
        }
        int answer = 1;
        int tmp = pq.poll().e;
        while(!pq.isEmpty()){
            Range r = pq.poll();
            if(r.s<tmp){
                answer++;
            }else{
                tmp = r.s;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
