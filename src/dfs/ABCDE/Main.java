package dfs.ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

//    static int[][] mat;
    static ArrayList[] graph;
    static int answer = 0;
    static int n,m;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new ArrayList[n];
        for(int i=0;i<n;i++) graph[i] = new ArrayList<Integer>();
        for(int i=0;i<m;i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0;i<n;i++){
            if(answer == 1) break;
            visited = new boolean[n];
            visited[i] = true;
            dfs(i,1);
        }
        System.out.println(answer);
        br.close();
    }

    public static void dfs(int node, int cnt){
        if(cnt==5){
            answer = 1;
            return ;
        }
        for(int i=0;i<graph[node].size();i++){
            if(answer == 1) return ;
            int next = (int) graph[node].get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(next,cnt+1);
                visited[next] = false;
            }
        }

    }
}
