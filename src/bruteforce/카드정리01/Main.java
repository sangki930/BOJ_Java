package bruteforce.카드정리01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        int[][] boxes = new int[n][m];

        for(int i=0;i<n;i++){
            boxes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        // 이동 한 번은 한 박스에서 1장이상의 카드를 빼 다른 박스에 넣는 것

        int answer = Integer.MAX_VALUE;

        // 조커 없음
        int[] used = new int[m]; // 같은 번호의 카드가 몇번 등장하는 지
        boolean flag = true;
        for(int i=0;i<boxes.length;i++){
            if(isBoxEmpty(boxes[i])) continue;

        }



        br.close();
    }

    public static boolean isBoxEmpty(int[] box){
        for(int i=0;i<box.length;i++){
            if(box[i]!=0) return  false;
        }
        return true;
    }

    public static int isOnlyOneColor(int[] box){
        int zero = 0;
        int nonzero = 0;
        int num = 0;
        for(int i=0;i<box.length;i++){
            if(box[i]==0){
                zero++;
            }else if(box[i]>0){
                num = i;
                nonzero++;
            }
        }
        if(nonzero == 1){
            return num;
        }
        return -1;
    }
}
