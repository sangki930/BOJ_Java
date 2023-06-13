package implementation.카드바꾸기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(i->Double.parseDouble(i)).toArray();
        Map<String,HashSet<String>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                double d = (arr[j]-arr[i])/(j-i);
                if((int)Math.floor(d)==(int)d){
                   String formula = "y="+d+"x+"+(-d*i+arr[i]);
                   HashSet<String> set = map.getOrDefault(formula,new HashSet<>());
                   set.add(Arrays.toString(new double[]{i,arr[i]}));
                   set.add(Arrays.toString(new double[]{j,arr[j]}));
                   map.put(formula,set);
                }
            }
        }

        int cnt = 0;
        for(String key : map.keySet()){
            cnt = Math.max(cnt,map.get(key).size());
        }
        System.out.println(n-cnt);

        br.close();
    }
}
