package bfs.뱀과사다리게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Data{
    int node;
    int dis;
    public Data(int node, int dis){
        this.node=node;
        this.dis=dis;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        int[] ladder = new int[101], snake = new int[101];

        for(int i=0;i<n;i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]), v = Integer.parseInt(input[1]);
            ladder[u] = v;
        }

        for(int i=0;i<m;i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]), v = Integer.parseInt(input[1]);
            snake[u] = v;
        }

        LinkedList<Data> queue = new LinkedList<>();
        queue.offer(new Data(1,0));
        int[] dis = new int[101];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[1] = 0;
        int answer = 0;
        while(!queue.isEmpty()){
            Data data = queue.poll();
            if(data.node==100){
                answer = data.dis;
                break;
            }
            for(int i=1;i<=6;i++){
                int nx = data.node + i;
                if(nx<1 || nx>100) continue;
                if(dis[nx]<=dis[data.node]+1) continue;
                if(snake[nx]>0){
                    dis[snake[nx]] = dis[nx] = dis[data.node]+1;
                    queue.offer(new Data(snake[nx], data.dis+1));
                }else if(ladder[nx]>0){
                    dis[ladder[nx]] = dis[nx] = dis[data.node]+1;
                    queue.offer(new Data(ladder[nx], data.dis+1));
                }else {
                    dis[nx] = dis[data.node]+1;
                    queue.offer(new Data(nx, data.dis+1));
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}
