package bfs.그림;

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
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        int[][] map = new int[n][m];

        for(int i=0;i<n;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        boolean[][] visited = new boolean[n][m];
        int answer = 0;
        int answer1 = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] || map[i][j]==0) continue;
                LinkedList<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i,j});
                visited[i][j] = true;
                int area = 1;
                while(!queue.isEmpty()){
                    int[] p = queue.poll();
                    for(int k=0;k<4;k++){
                        int nx = p[0] + dx[k];
                        int ny = p[1] + dy[k];
                        if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny]==1 && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx,ny});
                            area++;
                        }
                    }
                }
                answer1 = Math.max(answer1,area);
                answer++;
            }
        }
        System.out.println(answer);
        System.out.println(answer1);

        br.close();
    }
}
