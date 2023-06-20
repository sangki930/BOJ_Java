package greedy.선긋기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] ranges = new int[n][2];
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            ranges[i][0] = Integer.parseInt(tmp[0]);
            ranges[i][1] = Integer.parseInt(tmp[1]);
        }

        System.out.println(new Main().solution(ranges,n));

        br.close();
    }

    public long solution(int[][] ranges,int n){
        long answer = 0;

        Arrays.sort(ranges,
                (o1,o2)->{
                    if(o1[0]==o2[0]) return Integer.compare(o1[1],o2[1]);
                    return Integer.compare(o1[0],o2[0]);
                }
        );

        int s = ranges[0][0];
        int e = ranges[0][1];

        for(int i=1;i<n;i++){
            int[] range = ranges[i];
            if(range[0]>e){
                answer+=(e-s);
                s = range[0];
                e = range[1];

            }else if(s<=range[0] && range[0]<=e){
                e = Math.max(range[1],e);
            }
        }

        return answer+(e-s);
    }
}
