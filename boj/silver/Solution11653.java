package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution11653 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        br.close();

        int divider = 2;
        while (n != 1) {
            if (n % divider == 0) {
                sb.append(divider + "\n");
                n /= divider;
            } else {
                divider++;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}