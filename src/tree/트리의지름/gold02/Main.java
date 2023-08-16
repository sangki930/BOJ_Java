package tree.트리의지름.gold02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node{
    int e,w;

    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Node{" +
                "e=" + e +
                ", w=" + w +
                '}';
    }
}

public class Main {

    static int max = -1;
    static int end = -1;
    static boolean[] visited;
    static ArrayList<Node>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        for(int i=0;i<n;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            int p = Integer.parseInt(tmp[0])-1;
            for(int j=1;j<tmp.length-1;j+=2){
                int s = Integer.parseInt(tmp[j])-1;
                int w = Integer.parseInt(tmp[j+1]);
                tree[p].add(new Node(s,w));
            }
        }

        visited = new boolean[n];
        dfs(0,0);
        max = -1;
        visited = new boolean[n];
        dfs(end,0);
        System.out.println(max);
        br.close();
    }

    static void dfs(int node, int dist){

        visited[node] = true;
        if(dist>max){
            max = dist;
            end = node;
        }

        for(Node next : tree[node]){
            if(!visited[next.e]){
                dfs(next.e,dist+ next.w);
            }
        }
    }
}
