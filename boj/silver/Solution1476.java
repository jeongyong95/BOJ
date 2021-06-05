package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] esm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        int year = 1;

        int e = 1;
        int s = 1;
        int m = 1;

        while (true) {
            if (esm[0] == e && esm[1] == s && esm[2] == m) {
                break;
            }

            year++;

            e++;
            if (e == 16) {
                e = 1;
            }

            s++;
            if (s == 29) {
                s = 1;
            }

            m++;
            if (m == 20) {
                m = 1;
            }
        }

        bw.write(year + "\n");
        bw.flush();
        bw.close();
    }
}
