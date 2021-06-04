package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1748 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        br.close();

        int result = 0;
        int length = 1;
        int start = 1;
        while (start <= n) {
            int end = start * 10 - 1;
            if (end > n) {
                end = n;
            }

            result += (end - start + 1) * length;
            start *= 10;
            length++;
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
