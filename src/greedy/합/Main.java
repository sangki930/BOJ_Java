package greedy.합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            long[][] a = new long[10][2];

            for(int i=0;i<a.length;i++) a[i][1]=-1;

            for(int i=0;i<n;i++){
                String s = br.readLine();
                long m = 1;
                a[s.charAt(0)-'A'][1] = 1;
                for(int j=s.length()-1;j>=0;j--){
                    a[s.charAt(j)-'A'][0] += m;
                    m *= 10L;
                }
            }

            Arrays.sort(a,(o1,o2)->{
                return Long.compare(o2[0],o1[0]);
            });

            if(a[9][1]==1){
                for(int i=8;i>=0;i--){
                    if(a[i][1]==-1){
                        a[i] = null;
                        break;
                    }
                }
            }
            long answer = 0;
            for(int i=0,j=0;i<10;i++){
                if(a[i]==null) continue;
                answer +=a[i][0] * (9-j);
                j++;
            }
            System.out.println(answer);
            br.close();
        }
}