package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        Integer rn = 0;
        br.close();
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            for (int i = 0; i < rn; i++) {
                sb.append(' ');
            }
            for (int i = 0; i < n; i++) {
                sb.append('*');
            }
            sb.append("\n");
            n--;
            rn++;
        }
        System.out.println(sb);
    }
}