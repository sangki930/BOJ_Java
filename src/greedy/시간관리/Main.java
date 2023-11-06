package greedy.시간관리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Task{
    int t;
    int s;
    public Task(int t, int s){
        this.t=t;
        this.s=s;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Task> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            int t = Integer.parseInt(input[0]), s = Integer.parseInt(input[1]);
            list.add(new Task(t,s));
        }

        list.sort(
                (o1,o2)->{
                    if(o1.s==o2.s)
                      return Integer.compare(o1.t,o2.t);
                    return Integer.compare(o2.s,o1.s);
                }
        );
        int time = list.get(0).s-list.get(0).t;
        for(int i=1;i<list.size();i++) {
            Task task = list.get(i);
            if (time >= task.s) {
                time = task.s;
            }
            time -= task.t;
        }
        time = Math.max(-1,time);
        System.out.println(time);
        br.close();
    }
}
