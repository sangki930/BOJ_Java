package graph.녹색옷입은애가젤다지;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Node{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;

        }

    }

    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i=1;;i++){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            int[][] arr = new int[n][n];
            for(int j=0;j<n;j++){
                arr[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt(o->o.cost)
            );
            int[][] acc = new int[n][n];
            for(int j=0;j<acc.length;j++)
                Arrays.fill(acc[j],Integer.MAX_VALUE);
            // boolean[][] visited= new boolean[n][n];
            queue.offer(new Node(0,0,arr[0][0]));
            acc[0][0] = arr[0][0];
            int cost = 0;
            while(!queue.isEmpty()){
                Node p = queue.poll();

                if(p.x==n-1 && p.y==n-1) {
                    cost = p.cost;
                    break;
                }
                for(int k=0;k<4;k++){
                    int nx = p.x+dx[k];
                    int ny = p.y+dy[k];
                    if(0<=nx && nx<n && 0<=ny && ny<n && acc[nx][ny]>arr[nx][ny]+p.cost){
                        acc[nx][ny]=arr[nx][ny]+p.cost;
                        queue.offer(new Node(nx,ny,arr[nx][ny]+p.cost));

                    }
                }
            }

            System.out.println("Problem "+i+": "+cost);
        }

        br.close();
    }
}
