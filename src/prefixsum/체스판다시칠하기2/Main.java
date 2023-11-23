package prefixsum.체스판다시칠하기2;


import java.io.*;

public class Main {
    static int N, M, K, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[][] board;	//M×N배열에 색칠 관련 배열
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        board = new int[N+1][M+1];
        //false : 검은색, true : 흰색
        boolean color = false;

        for(int i=1;i<=N;i++){
            String str = br.readLine();
            for(int j=1;j<=M;j++){
                char c = str.charAt(j-1);
                if(!color && c == 'W')
                    board[i][j] = 1;
                else if(color && c == 'B')
                    board[i][j] = 1;
                color = !color;
            }
            if(M % 2 == 0)
                color = !color;
        }

        for(int i=1;i<=N;i++){
            int temp = board[i][1];
            for(int j=2;j<=M;j++){
                temp += board[i][j];
                board[i][j] = temp;
            }
        }

        for(int i=1;i<=M;i++){
            int temp = board[1][i];
            for(int j=2;j<=N;j++){
                temp += board[j][i];
                board[j][i] = temp;
            }
        }

        for(int i=K;i<=N;i++){
            for(int j=K;j<=M;j++){

                int temp = board[i][j] - (board[i-K][j] + board[i][j-K] - board[i-K][j-K]);
                min = Math.min(min, temp);
                max = Math.max(max, temp);
            }
        }
        int answer = Math.min(min, K*K - max);	//최소 횟수 구하기
        bw.write(answer + "");	//최소 횟수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}