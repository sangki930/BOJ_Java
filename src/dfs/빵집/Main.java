package dfs.빵집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[] map = new String[r];
        for(int i=0;i<r;i++){
            map[i] = br.readLine();
        }

        System.out.println(new Main().solution(r,c,map));

        br.close();
    }

    boolean isFind = false;
    String[] map;
    int[] dx = {-1,0,1}, dy = {1,1,1};
    int r,c;
    boolean[][] visited;
    public int solution(int r, int c, String[] map){
        this.map = map;
        this.r=r;
        this.c=c;
        this.visited = new boolean[r][c];
        int answer = 0;
        for(int i=0;i<r;i++){
            isFind = false;
            dfs(i,0);
            if(isFind) answer++;
        }

        return answer;
    }

    public void dfs(int x, int y){
        visited[x][y] = true;
        if(y==c-1){
            isFind = true;
            return ;
        }
        for(int i=0;i<3;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<r && 0<=ny && ny<c && !visited[nx][ny] && map[nx].charAt(ny)!='x')
                dfs(nx,ny);
            if(isFind) return ;
        }
    }
}
