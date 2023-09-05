package dfs.텀프로젝트;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            visited = new boolean[n];
            finished = new boolean[n];
            answer = 0;
            for(int j=0;j<n;j++){
                dfs(j);
            }
            System.out.println(n-answer);
        }

        br.close();
    }

    static void dfs(int num){
        if(visited[num]) return;
        visited[num] = true;
        int next = arr[num]-1;
        if(!visited[next]) dfs(next);
        else{
            if(!finished[next]){
                answer++;
                for(int i=next; i != num; i = arr[i]-1)
                    answer++;
            }
        }
        finished[num] = true;
    }
}
