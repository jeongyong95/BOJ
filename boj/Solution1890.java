package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1890 {
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dp = new long[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        dp();
        bw.write(dp[n - 1][n - 1] + "\n");
        bw.flush();
        bw.close();
    }

    static void dp() {
        dp[0][0] = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                int jumpN = i + map[i][j];
                int jumpM = j + map[i][j];

                if (jumpN < dp.length) {
                    dp[jumpN][j] += dp[i][j];
                }
                if (jumpM < dp.length) {
                    dp[i][jumpM] += dp[i][j];
                }
            }
        }
    }
}
