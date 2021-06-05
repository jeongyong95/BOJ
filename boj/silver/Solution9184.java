package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9184 {

    private static int[][][] result = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            input = br.readLine();
            if (input.equals("-1 -1 -1")) {
                break;
            }
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append("w" + "(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
        }
        System.out.println(sb);
        br.close();
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a <= 20 && b <= 20 && c <= 20 && result[a][b][c] != 0) {
            return result[a][b][c];
        }
        if (a > 20 || b > 20 || c > 20) {
            return result[20][20][20] = w(20, 20, 20);
        }

        if (a < b && b < c) {
            return result[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return result[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}