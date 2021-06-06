package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution9251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static char[] arr1;
    static char[] arr2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();
        br.close();

        dp = new int[arr1.length + 1][arr2.length + 1];
        dp();

        bw.write(dp[arr1.length][arr2.length] + "\n");
        bw.flush();
        bw.close();
    }

    static void dp() {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}