package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution12865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] wv;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        wv = new int[2][n + 1];
        dp = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            wv[0][i] = Integer.parseInt(st.nextToken());
            wv[1][i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= wv[0][i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - wv[0][i]] + wv[1][i]);
            }
        }
        bw.write(dp[k] + "\n");
        bw.flush();
        bw.close();
    }
}