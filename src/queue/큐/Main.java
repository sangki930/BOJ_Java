package queue.큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue=new LinkedList<>();

        for(int i=0;i<n;i++){
            String[] cmd = br.readLine().split(" ");

            int print = 0;
            switch (cmd[0]){
                case "push"->{
                    queue.offer(Integer.parseInt(cmd[1]));
                    continue;
                }
                case "front"->{
                    print = queue.isEmpty()?-1:queue.peekFirst();
                }
                case "back"->{
                    print = queue.isEmpty()?-1:queue.peekLast();
                }
                case "size"->{
                    print = queue.size();
                }
                case  "empty"->{
                    print = queue.isEmpty()?1:0;
                }
                case "pop"->{
                    print = queue.isEmpty()?-1:queue.poll();
                }

            }
            System.out.println(print);
        }

        br.close();
    }
}
