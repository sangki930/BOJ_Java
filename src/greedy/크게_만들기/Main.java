package greedy.크게_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
class Pair{
    int id;
    char c;
    public Pair(int id, char c){
        this.id=id;
        this.c=c;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        String num = br.readLine();
        System.out.println(new Main().solution(n,k,num));
        br.close();
    }

    public String solution(int n, int k, String num){
        StringBuilder sb = new StringBuilder();

        char[] ch = num.toCharArray();

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (o1,o2)->{
                    if(o1.c==o2.c)
                        return Integer.compare(o1.id,o2.id);
                    return Character.compare(o2.c,o1.c);
                }
        );
        int i=0;
        for(i=0;i<k+1;i++){
            pq.offer(new Pair(i,ch[i]));
        }
        int id = -1;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            if(sb.length()==n-k) break;
            if(id<pair.id){
                id = pair.id;
                sb.append(pair.c);
                if(i<n) pq.offer(new Pair(i,ch[i++]));
            }

        }

        return sb.toString();
    }
}
