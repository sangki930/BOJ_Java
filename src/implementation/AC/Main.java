package implementation.AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        loop : for(int i=0;i<t;i++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine().replaceAll(",",""));
            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");

            LinkedList<String> deque = new LinkedList<>();
            for(int j=0;j<n;j++) deque.offer(st.nextToken());

            boolean reverse = false;

            for(int j=0;j<p.length();j++){
                char c = p.charAt(j);
                //System.out.print(c);
                if(c=='D'){
                    if(deque.isEmpty()){
                        sb.append("error\n");
                        continue loop;
                    }
                    if(!reverse){ // 정방향
                        deque.pollFirst();
                    }else{ // 역방향
                        deque.pollLast();
                    }
                }else if(c=='R'){
                    if(!reverse){ // 정방향
                        reverse = true;
                    }else{ // 역방향
                        reverse = false;
                    }
                }
            }
            if(reverse)
                Collections.reverse(deque);
            sb.append(deque.toString().replaceAll(" ","")+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}