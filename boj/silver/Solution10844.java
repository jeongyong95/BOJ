package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution10844 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        int[][] arr = new int[101][10];

        for (int i = 1; i <= 9; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    if (i == 2) {
                        arr[i][j] = 1;
                    } else
                        arr[i][j] = arr[i - 1][1];
                } else if (j == 9) {
                    arr[i][j] = arr[i - 1][8];
                } else
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
                arr[i][j] %= 1000000000;
            }
        }

        for (int i = 0; i <= 9; i++) {
            result += arr[n][i];
            result %= 1000000000;
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
