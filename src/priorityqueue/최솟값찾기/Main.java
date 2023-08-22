package priorityqueue.최솟값찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Data{
    int v;
    int id;
    public Data(int id,int v){
        this.id=id;
        this.v=v;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), l = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        LinkedList<int[]> queue = new LinkedList<>();

        br.close();
    }
}
