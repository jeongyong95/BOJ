package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] strings = br.readLine().split(" ");
            int h = Integer.parseInt(strings[0]);
            int w = Integer.parseInt(strings[1]);
            int n = Integer.parseInt(strings[2]);

            int y = n % h;
            int x = n / h + 1;

            if (n % h == 0) {
                y = h;
                x = n / h;
            }
            sb.append((y * 100 + x) + "\n");
        }
        System.out.println(sb);
    }
}