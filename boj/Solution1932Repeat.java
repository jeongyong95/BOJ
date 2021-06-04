package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1932Repeat {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][];
        int[][] dp = new int[n + 1][];

        for (int i = 1; i <= n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        dp[1] = new int[1];
        dp[1][0] = arr[1][0];

        for (int i = 2; i <= n; i++) {
            dp[i] = new int[arr[i].length];
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if (j == dp[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                }
            }
        }

        int max = dp[n][0];

        for (int i : dp[n]) {
            if (max < i) {
                max = i;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
