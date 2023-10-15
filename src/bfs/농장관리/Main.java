package bfs.농장관리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Data{
    int x,y;
    int h;
    public Data(int x, int y, int h){
        this.x=x;
        this.y=y;
        this.h=h;
    }
}
public class Main {

    static int[] dx = {-1,-1,-1,1,1,1,0,0}, dy = {-1,0,1,-1,0,1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int answer = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]) continue;
                int h = map[i][j]; // 높이
                LinkedList<Data> queue = new LinkedList<>();
                queue.offer(new Data(i,j,h));
                visited[i][j] = true;
                boolean flag = true; // true : 산봉우리, false : 산봉우리 아님
                while (!queue.isEmpty()){
                    Data data = queue.poll();
                    for(int k=0;k<8;k++){
                        int nx = data.x+dx[k];
                        int ny = data.y+dy[k];
                        // 경계선 안에 오면
                        if(0<=nx && nx<n && 0<=ny && ny<m){
                            if(map[nx][ny]==h && !visited[nx][ny]){
                                queue.offer(new Data(nx,ny,map[nx][ny]));
                                visited[nx][ny] = true;
                            }else if(map[nx][ny]>h){
                                flag = false;
                            }
                        }
                    }
                }
                if(flag) answer++;
            }
        }
        System.out.println(answer);

        br.close();
    }
}
