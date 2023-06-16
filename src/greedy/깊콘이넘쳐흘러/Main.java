package greedy.깊콘이넘쳐흘러;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Gifticon{
    long extra;
    long limit;
    public Gifticon(long extra, long limit){
        this.extra=extra;
        this.limit=limit;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 기프티콘 남은 기한
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 며칠 뒤에 사용할 건 지

        PriorityQueue<Gifticon> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if(o1.extra==o2.extra)
                        return Long.compare(o1.limit,o2.limit);
                    return Long.compare(o1.extra,o2.extra);
                }
        );
        for(int i=0;i<n;i++){
            pq.offer(new Gifticon(a[i],b[i]));
        }

        int answer = 0;
        while(!pq.isEmpty()){
            Gifticon gifticon = pq.poll();
            if(gifticon.extra<gifticon.limit){
                answer+=Math.ceil((gifticon.limit- gifticon.extra)/30.0);
                gifticon.extra+=Math.ceil((gifticon.limit- gifticon.extra)/30.0)*30L;
                pq.offer(gifticon);
            }
        }

        System.out.println(answer);

        br.close();
    }
}
