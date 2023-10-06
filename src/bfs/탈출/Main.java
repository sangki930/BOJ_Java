package bfs.탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Data{
    int x;
    int y;
    int time;
    char v;

    public Data(int x, int y, int time, char v) {
        this.x = x;
        this.y=y;
        this.time=time;
        this.v=v;
    }
}

public class Main {

    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int r = Integer.parseInt(input[0]), c = Integer.parseInt(input[1]);
        char[][] map = new char[r][c];
        int d_r = -1, d_c = -1;
        int s_r = -1, s_c = -1;
        LinkedList<Data> queue = new LinkedList<>();
        for(int i=0;i<r;i++){
            input = br.readLine().split("");
            for(int j=0;j<c;j++){
                map[i][j] = input[j].charAt(0);
                if(map[i][j]=='D'){
                    d_r = i;d_c = j;
                }else if(map[i][j]=='S'){
                    s_r = i;s_c = j;
                }else if(map[i][j]=='*'){
                    queue.offer(new Data(i,j,0,'*'));
                }
            }
        }

        queue.offer(new Data(s_r,s_c,0,'H'));
        boolean[][] visited = new boolean[r][c];
        int answer = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Data data = queue.poll();

            if(data.x==d_r && data.y==d_c){

                answer = Math.min(answer,data.time);
                continue;
            }

            for(int i=0;i<4;i++){
                int nx = data.x+dx[i];
                int ny = data.y+dy[i];
                char v = data.v;
                if(v=='H'){
                    if(0<=nx && nx<r && 0<=ny && ny<c && (map[nx][ny]=='.' || map[nx][ny]=='D')){
                        queue.offer(new Data(nx,ny,data.time+1,'H'));
                        map[nx][ny] = 'H';
                    }
                }else if(v=='*'){

                    if(0<=nx && nx<r && 0<=ny && ny<c && map[nx][ny]!='X' && map[nx][ny]!='*' && map[nx][ny]!='D'){
                        map[nx][ny] = '*';
                        queue.offer(new Data(nx,ny,data.time+1,'*'));
                    }

                }
            }
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println("KAKTUS");
            return;
        }
        System.out.println(answer);
        br.close();
    }
}
