package dfs.미친로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static double e,w,s,n;
    static boolean[][] visited = new boolean[100][100];
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static double[] dir;
    static double answer = 0.0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1])/100.0;
        w = Integer.parseInt(input[2])/100.0;
        s = Integer.parseInt(input[3])/100.0;
        n = Integer.parseInt(input[4])/100.0;
        dir = new double[]{e,w,s,n};

        move(50,50,0,1);

        System.out.println(answer);
        br.close();
    }

    public static void move(int x, int y, int level, double acc){
        if(level==N){
            answer+=acc;
            return ;
        }
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x + dx[i], ny = y + dy[i];
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                move(nx,ny,level+1,acc*dir[i]);
                visited[nx][ny] = false;
            }
        }

    }
}
