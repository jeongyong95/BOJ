package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  직사각형에서 탈출
    한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)에 있고, 
    오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
    첫째 줄에 x y w h가 주어진다. w와 h는 1,000보다 작거나 같은 자연수이고, 
    x는 1보다 크거나 같고, w-1보다 작거나 같은 자연수이고, y는 1보다 크거나 같고, h-1보다 작거나 같은 자연수이다.
    첫째 줄에 문제의 정답을 출력한다.
 */
public class Solution1085 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int x, y, w, h, shortestPath, sx, sy;
        String[] line = bufferedReader.readLine().split(" ");
        bufferedReader.close();

        x = Integer.parseInt(line[0]);
        y = Integer.parseInt(line[1]);
        w = Integer.parseInt(line[2]);
        h = Integer.parseInt(line[3]);

        sx = w - x > x ? x : w - x;
        sy = h - y > y ? y : h - y;
        shortestPath = sx > sy ? sy : sx;

        bufferedWriter.write(shortestPath + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}