package graph.여행가자;

import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        int[][] mat = new int[n][n];
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                int num = Integer.parseInt(input[j]);
                mat[i][j] = num;
                if(mat[i][j]==1){
                    union(i,j);
                }
            }
        }
        String answer = "YES";
        int[] path = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = find(path[0]-1);
        for(int i=1;i<m;i++){
            if(start != find(path[i]-1)){
                answer = "NO";
                break;
            }
        }

        bw.write(answer);
        bw.flush();

        bw.close();
        br.close();
    }

    public static int find(int x){
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}
