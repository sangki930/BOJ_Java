package sweeping.흙길보수하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Puddle{
    int s,e;
    public Puddle(int s, int e){
        this.s=s;
        this.e=e;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), l =Integer.parseInt(input[1]);
        List<Puddle> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]), e = Integer.parseInt(input[1]);
            list.add(new Puddle(s,e));
        }

        list.sort(
                (a,b)->{
                    if(a.s==b.s) return Integer.compare(b.e,a.e);
                    return Integer.compare(a.s,b.s);
                }
        );

        int answer = 0;
        int start = -1, end = -1;
        for(int i=0;i<n;i++){
            Puddle p = list.get(i);
            if(end<=p.s){
                start = p.s;
                end = p.s+l*(int)Math.ceil((p.e-p.s)*1.0/l);
                answer+=(int)Math.ceil((p.e-p.s)*1.0/l);
            }else if(p.s<=end && end<p.e){
                answer+=(int)Math.ceil((p.e-end)*1.0/l);
                end += l*(int)Math.ceil((p.e-end)*1.0/l);
            }
            //System.out.println("start : "+start+", end : "+end+", answer : "+answer);
        }
        System.out.println(answer);
        br.close();
    }
}
