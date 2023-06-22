package greedy.센서;

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

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n-1;i++)
            list.add(arr[i+1]-arr[i]);
        list.sort(Comparator.comparingInt(a -> a));

        System.out.println(list.subList(0,Math.max(n-k,0)).stream().mapToInt(Integer::intValue).sum());
        br.close();
    }
}
