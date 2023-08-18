package tree.트리의순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] inorder;
    static int[] postorder;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        func(0,n,0,n);
        System.out.print(sb);
        br.close();
    }

    public static void func(int il, int ir, int pl, int pr){
        if( ir-il != pr - pl){
            return;
        }
        if (il < ir && pl < pr){
            for (int i=0;i<ir-il;i++){
                if(inorder[il+i]==postorder[pr-1]){
                    sb.append(postorder[pr-1]).append(" ");
                    func(il,il+i,pl,pl+i);
                    func(il+i+1,ir,pl+i,pr-1);
                }

            }
        }
    }
}
