package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        int rn = n;
        br.close();
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            for (int i = n; i < rn; i++) {
                sb.append(' ');
            }
            for (int i = 0; i < n * 2 - 1; i++) {
                sb.append('*');
            }
            sb.append('\n');
            n--;
        }
        System.out.println(sb);
    }
}