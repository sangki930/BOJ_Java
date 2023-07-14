package tree.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{

    static ArrayList<Integer>[] graph;
    static int[] depth;
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        parents = new int[n+1];
        depth = new int[n+1];
        String[] tmp;
        for(int i=0;i<n-1;i++){
            tmp = br.readLine().split(" ");
            int s=Integer.parseInt(tmp[0]), e = Integer.parseInt(tmp[1]);
            if(graph[s]==null) graph[s] = new ArrayList<>();
            if(graph[e]==null) graph[e] = new ArrayList<>();
            graph[s].add(e);
            graph[e].add(s);
        }
        dfs(1,0);
        int m = Integer.parseInt(br.readLine());
//        System.out.println(Arrays.toString(graph));
        for(int i=0;i<m;i++){
            tmp = br.readLine().split(" ");
            int s=Integer.parseInt(tmp[0]), e = Integer.parseInt(tmp[1]);
            System.out.println(lca(s,e));
        }
        br.close();
    }

    public static void dfs(int node, int level){
        if(visited[node]) return;
        visited[node] = true;
        depth[node] = level;
//        System.out.println(graph[node]);
        for(int e : graph[node]){
            if(!visited[e]){
                parents[e] = node;
                dfs(e,level+1);
            }
        }
    }

    public static int lca(int a, int b){
        while(depth[a]!=depth[b]){
            if(depth[a]>depth[b]){
                a = parents[a];
            }else{
                b = parents[b];
            }
        }

        while(a!=b){
            a = parents[a];
            b = parents[b];
        }
        return a;
    }
}
