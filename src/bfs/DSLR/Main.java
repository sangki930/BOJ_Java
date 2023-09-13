package bfs.DSLR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Data{
    int num;
    String cmd;
    public Data(int num,String cmd){
        this.num=num;
        this.cmd=cmd;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            LinkedList<Data> queue = new LinkedList<>();
            queue.offer(new Data(input[0],""));
            boolean[] visited = new boolean[10000];
            while (!queue.isEmpty()){
                Data data = queue.poll();
                if(data.num==input[1]){
                    sb.append(data.cmd).append("\n");
                    break;
                }
                int d = D(data.num);
                int s = S(data.num);
                int l = L(data.num);
                int r = R(data.num);
                if(!visited[d]){
                    queue.offer(new Data(d, data.cmd+"D"));
                    visited[d] = true;
                }

                if(!visited[s]){
                    queue.offer(new Data(s, data.cmd+"S"));
                    visited[s] = true;
                }

                if(!visited[l]){
                    queue.offer(new Data(l, data.cmd+"L"));
                    visited[l] = true;
                }

                if(!visited[r]){
                    queue.offer(new Data(r, data.cmd+"R"));
                    visited[r] = true;
                }

            }
        }
        System.out.print(sb);
        br.close();
    }

    public static int D(int n){
        return (n*2)%10000;
    }

    public static int S(int n){
        if(n<=0) return 9999;
        return n-1;
    }

    public static int L(int n){
//        String ret = String.format("%04d",n);
//        return Integer.parseInt(ret.substring(1)+ret.charAt(0));
        return (n % 1000) * 10 + n/1000;
    }

    public static int R(int n){
//        String ret = String.format("%04d",n);
//        return Integer.parseInt(ret.charAt(ret.length()-1)+ret.substring(0,ret.length()-1));
        return (n % 10) * 1000 + n/10;
    }

}
