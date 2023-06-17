package greedy.깊콘이넘쳐흘러;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        long[] a = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray(); // 기프티콘 남은 기한
        long[] b = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray(); // 며칠 뒤에 사용할 건 지

        ArrayList<Gifticon> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            arr.add(new Gifticon(a[i],b[i]));
        }

        arr.sort((o1,o2)->{
            if(o1.limit==o2.limit) return Long.compare(o1.extra,o2.extra);
            return Long.compare(o1.limit,o2.limit);
        });

        long prev = arr.get(0).limit;
        long cur_max = -1;
        long answer = 0;
        long cnt = 0;
        for(int i=0;i<n;i++){

            Gifticon gifticon = arr.get(i);
            if(prev>gifticon.extra){
                prev = Math.max(gifticon.limit,prev);
                cnt = (long)Math.ceil((prev- gifticon.extra)/30.0);

                arr.get(i).extra+=cnt*30;
                answer+=cnt;
            }
            cur_max = Math.max(cur_max,gifticon.extra);
            if(i+1<n && arr.get(i).limit!=arr.get(i+1).limit){
                prev = cur_max;
            }
        }
        System.out.println(answer);

        br.close();
    }
}
