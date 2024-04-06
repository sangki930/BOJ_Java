package sort.좌표정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Point{
    int x,y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<Point>();
        for(int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            points.add(new Point(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
        }
        points.sort((a,b)->{
            if(a.x==b.x)
                return a.y-b.y;
            return a.x-b.x;
        });

        for(Point p : points) {
            System.out.println(p.x+" "+p.y);
        }

        br.close();
    }
}
