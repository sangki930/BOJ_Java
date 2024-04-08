package implementation.되돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Log{
    String s;
    int time;
    public Log(String s, int time){
        this.s = s;
        this.time = time;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Log> logs = new ArrayList<Log>();
        logs.add(new Log("", 0));
        for(int i=1;i<=n;i++){
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[2]);
            switch (input[0]){
                case "type"->{
                    logs.add(new Log(logs.get(i-1).s+input[1],time));
                }
                case "undo"->{
                    boolean flag = false;
                    int start = time - Integer.parseInt(input[1])-1;
                    for(int j=i-1;j>=0;j--){
                        if(start<0) break;
                        Log log = logs.get(j);

                        if(log.time<=start){
                            logs.add(new Log(log.s,time));
                            flag = true;
                            break;
                        }
                    }

                    if(!flag) logs.add(new Log("",time));
                }
            }
        }
        System.out.println(logs.get(n).s);
        br.close();
    }
}