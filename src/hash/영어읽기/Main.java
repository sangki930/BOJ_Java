package hash.영어읽기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String,Integer> counter = new HashMap<>();
        for(int i=0;i<n;i++){
            String s = br.readLine();
            String key = makeKey(s);
            counter.put(key,counter.getOrDefault(key,0)+1);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = 1;
            while (st.hasMoreTokens()){
                String key = makeKey(st.nextToken());
                cnt *= counter.getOrDefault(key,0);
            }
            System.out.println(cnt);
        }
        br.close();
    }

    public static String makeKey(String s){
        if(s.length()==1) return s;
        String key = s.charAt(0)+"|";
        int[] alpha = new int['z'-'A'+1];
        for(int i=1;i<s.length()-1;i++){
            char c = s.charAt(i);
            alpha[c-'A']++;
        }

        for(int i=0;i<alpha.length;i++){
            if(alpha[i]>0){
                key = key + ((char)('A'+i))+alpha[i]+"|";
            }
        }

        return key+s.charAt(s.length()-1);
    }
}
