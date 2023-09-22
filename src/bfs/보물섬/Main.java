package bfs.보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]), c = Integer.parseInt(input[1]);
        char[][] map = new char[r][c];
        for(int i=0;i<r;i++){
            map[i] = br.readLine().toCharArray();
        }
        int answer = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j]=='W') continue;
                int[][] dis = new int[r][c];
                for(int k=0;k<r;k++)
                    Arrays.fill(dis[k],Integer.MAX_VALUE);
                LinkedList<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i,j});
                dis[i][j] = 0;
                while(!queue.isEmpty()){
                    int[] p = queue.poll();
                    for(int k=0;k<4;k++){
                        int nx = p[0] + dx[k];
                        int ny = p[1] + dy[k];
                        if(0 <= nx && nx < r && 0 <= ny && ny < c && map[nx][ny]=='L'){
                            if(dis[nx][ny]>dis[p[0]][p[1]]+1){
                                queue.offer(new int[]{nx,ny});
                                dis[nx][ny]=dis[p[0]][p[1]]+1;
                                answer = Math.max(dis[nx][ny],answer);
                            }
                        }
                    }
                }


            }
        }
        System.out.println(answer);

        br.close();
    }
}
