package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        br.close();

        Integer rn = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            sb.append(' ');
        }
        sb.append("*\n");
        n--;

        Integer temp = n;

        while (n > 0) {
            n--;
            for (int i = 0; i < n; i++) {
                sb.append(' ');
            }
            sb.append('*');

            rn++;
            if (rn == temp) {
                for (int i = 0; i < rn * 2 - 1; i++) {
                    sb.append('*');
                }
                sb.append("*\n");
                break;
            }

            for (int i = 0; i < rn * 2 - 1; i++) {
                sb.append(' ');
            }
            sb.append("*\n");
        }
        System.out.println(sb);
    }
}