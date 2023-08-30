package greedy.최소회의실개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new TreeMap<>((a,b)->a-b);

        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]), e = Integer.parseInt(input[1]);
            map.put(s, map.getOrDefault(s,0)+1);
            map.put(e, map.getOrDefault(e,0)-1);
        }

        int prev = -1;
        int idx = 0;
        int answer = 0;
        for(int key  : map.keySet()){
            if(idx==0){
                prev = map.get(key);
            }else{
                prev = map.get(key)+prev;
            }
            answer = Math.max(prev,answer);
            idx++;
        }
        System.out.println(answer);

        br.close();
    }
}
