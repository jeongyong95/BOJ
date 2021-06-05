package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        br.close();
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            for (int i = 0; i < n; i++) {
                sb.append('*');
            }
            sb.append("\n");
            n--;
        }
        System.out.println(sb);
    }
}