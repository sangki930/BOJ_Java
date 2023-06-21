package greedy.도서관;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        long answer = 0;
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> p_list = new ArrayList<>(), n_list = new ArrayList<>();
        int last = 0;
        for(int i=0;i<arr.length;i++){
            last = Math.max(last,Math.abs(arr[i]));
            if(arr[i]>0) p_list.add(arr[i]);
            else if(arr[i]<0) n_list.add(-arr[i]);
        }
        p_list.sort(Comparator.reverseOrder());
        n_list.sort(Comparator.reverseOrder());

        for(int i=0;i<p_list.size();i+=m) answer+=p_list.get(i)*2;
        for(int i=0;i<n_list.size();i+=m) answer+=n_list.get(i)*2;
        System.out.println(answer-last);

        br.close();
    }
}
