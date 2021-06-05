package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution11057 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int[][] arr = new int[1001][10];
        for (int i = 0; i <= 9; i++) {
            arr[1][i] = 1;
        }

        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= 9; j++) {
                    for (int k = 0; k <= j; k++) {
                        arr[i][j] += arr[i - 1][k] % 10007;
                    }
                }
            }
        }
        bw.write(Arrays.stream(arr[n]).sum() % 10007 + "\n");
        bw.flush();
        bw.close();
    }
}
