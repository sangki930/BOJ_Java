package graph.친구네트워크;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[] parent;
    static int[] cnts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            Map<String,Integer> map = new HashMap<>();
            int f = Integer.parseInt(br.readLine());
            int id = 1;
            parent = new int[200001];
            cnts = new int[200001];
            for(int k=1;k<parent.length;k++){
                parent[k] = k;
                cnts[k] = 1;
            }
            for(int j=0;j<f;j++){
                String[] input = br.readLine().split(" ");
                for(int k=0;k<2;k++){
                    if(!map.containsKey(input[k])){
                        map.put(input[k],id++);
                    }
                }

                int a = map.get(input[0]);
                int b = map.get(input[1]);
                System.out.println(union(a,b));
            }
        }


        br.close();
    }

    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static int union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y) {
            int mx = Math.min(x,y);
            int my = Math.max(x,y);
            parent[my] = mx;
            cnts[mx] += cnts[my];
            cnts[my] = 1;
        }

        return cnts[Math.min(x,y)];
    }
}
