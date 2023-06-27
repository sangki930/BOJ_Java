package bfs.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
        //int m = sc.nextInt();
        ArrayList<Integer> graph[] = new ArrayList[n+1];
        for(int i=0;i<=n;i++) graph[i] = new ArrayList<Integer>();

        for(int i=0;i<m;i++){
//            int s = sc.nextInt();
//            int e = sc.nextInt();
            String[] tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]), e = Integer.parseInt(tmp[1]);
            graph[s].add(e);
            graph[e].add(s);
        }

        boolean[] infested = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        infested[1] = true;
        int cnt = 0;
        while (!queue.isEmpty()){

            Integer computer = queue.poll();
            if(computer==null) continue;

            for(int next : graph[computer]){
                if(!infested[next]){
                    infested[next] = true;
                    cnt++;
                    queue.offer(next);

                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
