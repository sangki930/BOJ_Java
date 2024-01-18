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

        br.close();
    }

}
