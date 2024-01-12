package implementation.되돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Pair{
    String text;
    int time;
    public Pair(String text, int time){
        this.text=text;
        this.time=time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();

        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            switch (cmd){
                case "type"->{
                    String text = input[1];
                    int time = Integer.parseInt(input[2]);
                    stack.push(new Pair(text,time));
                }
                case "undo"->{
                    int range = Integer.parseInt(input[1]);
                    int time = Integer.parseInt(input[2]);
                    while(!stack.isEmpty() && (time-range)<=stack.peek().time){
                        stack.pop();
                    }
                }
            }
        }
        String answer = "";
        while(!stack.isEmpty()){
            answer  = stack.pop().text+answer;
        }
        System.out.println(answer);
        br.close();
    }
}
