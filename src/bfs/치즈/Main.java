package bfs.치즈;

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

        for(int i=0;i<n;i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        int answer2 = 0;
        while(true){
            LinkedList<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0});
            map[0][0] = 2;
            int cnt = 1;

            while(!queue.isEmpty()){
                int[] p = queue.poll();
                for(int i=0;i<4;i++){
                    int nx = p[0]+dx[i];
                    int ny = p[1]+dy[i];
                    if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny]==0) {
                        queue.offer(new int[]{nx, ny});
                        map[nx][ny] = 2;
                        cnt++;
                    }
                }
            }
            if(cnt==n*m) break;
            answer2 = 0;
            // 가장자리엔 치즈가 없다.
            for(int i=1;i<n-1;i++){
                for(int j=1;j<m-1;j++){
                    if(map[i][j]!=1) continue;
                    int outer = 0;
                    for(int k=0;k<4;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(map[nx][ny]==2) outer++;
                    }
                    if(outer>=1) {
                        map[i][j] = 3;
                        answer2++;
                    }
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j] == 2 || map[i][j] == 3){
                        map[i][j] = 0;
                    }
                }
            }

//            for(int i=0;i<n;i++)
//                System.out.println(Arrays.toString(map[i]));
//            System.out.println("==================================");

            answer++;
        }

        System.out.println(answer);
        System.out.println(answer2);

        br.close();
    }
}
