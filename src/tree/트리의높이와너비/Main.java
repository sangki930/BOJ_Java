package tree.트리의높이와너비;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node{
    int id;
    int level;
    int col;
    public Node(int id, int level){
        this.id=id;
        this.level=level;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", level=" + level +
                ", col=" + col +
                '}';
    }
}

class Data{
    int level;
    int diff;
    public Data(int level, int diff){
        this.level=level;
        this.diff=diff;
    }
}

public class Main {

    static boolean[] visited;
    static int[][] tree;
    static Node[] nodes;
    static int num = 1;
    static int[][] levels = new int[10001][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        nodes = new Node[n+1];
        tree = new int[n+1][2];
        nodes[1] = new Node(1,1);
        for(int i=1;i<=n;i++){
            String[] tmp = br.readLine().split(" ");
            int p = Integer.parseInt(tmp[0]);
            int l = Integer.parseInt(tmp[1]);
            int r = Integer.parseInt(tmp[2]);
            tree[p][0] = l;
            tree[p][1] = r;
            nodes[i] = new Node(i,0);
        }
        visited = new boolean[n+1];
        inorder(1,1);

        Arrays.sort(levels,(a,b)->{
            if(Math.abs(a[1]-a[2]) == Math.abs(b[1]-b[2])){
                return a[0]-b[0];
            }
            return Integer.compare(Math.abs(b[1]-b[2]),Math.abs(a[1]-a[2]));
        });
//
//        for(int[] l : levels){
//            System.out.println(Arrays.toString(l));
//        }
        System.out.println(levels[0][0]+" "+(levels[0][1]-levels[0][2]+1));
        br.close();
    }

    public static void inorder(int node, int level){
        if(tree[node][0]!=-1)
            inorder(tree[node][0], level+1);
        // 부모노드
        visited[node] = true;
        nodes[node].level = level;
        nodes[node].col = (num++);

        if(Arrays.toString(levels[level]).equals(Arrays.toString(new int[]{0,0,0}))){
            levels[level] = new int[]{level,nodes[node].col,nodes[node].col};
        }else{
            levels[level][1] = Math.max(levels[level][1],nodes[node].col);
            levels[level][2] = Math.min(levels[level][2],nodes[node].col);
        }
        if(tree[node][1]!=-1)
            inorder(tree[node][1],level+1);

    }
}
