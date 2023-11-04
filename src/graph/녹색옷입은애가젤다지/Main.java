package graph.녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i=1;;i++){ss
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            int[][] arr = new int[n][n];
            for(int j=0;j<n;j++){
                arr[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int[][] acc = new int[n][n];
            acc[0][0] = arr[0][0];

            PriorityQueue<int[]> queue = new PriorityQueue<>(
                    (o1,o2)->{
                        return Integer.compare(o1[2],o2[2]);
                    }
            );
            boolean[][] visited= new boolean[n][n];
            queue.offer(new int[]{0,0,arr[0][0]});
            visited[0][0]=true;
            while(!queue.isEmpty()){
                int[] p = queue.poll();
                for(int k=0;k<4;k++){
                    int nx = p[0]+dx[k];
                    int ny = p[1]+dy[k];
                    if(0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny]){
                        acc[nx][ny]=arr[p[0]][p[1]]+p[2];
                        queue.offer(new int[]{nx,ny,acc[nx][ny]});
                        visited[nx][ny] = true;
                    }
                }
            }

            System.out.println("Problem "+i+":"+acc[n-1][n-1]);
        }

        br.close();
    }
}
