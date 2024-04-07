package geometric.CCW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        double p1_x = Integer.parseInt(input[0]), p1_y = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        double p2_x = Integer.parseInt(input[0]), p2_y = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        double p3_x = Integer.parseInt(input[0]), p3_y = Integer.parseInt(input[1]);

        System.out.println(ccw(p1_x, p1_y, p2_x, p2_y, p3_x, p3_y));

        br.close();
    }

    static int ccw(double x1, double y1, double x2, double y2, double x3, double y3) {
        double temp = x1*y2+x2*y3+x3*y1;
        temp = temp - y1*x2-y2*x3-y3*x1;
        if (temp > 0) {
            return 1;
        } else if (temp < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
