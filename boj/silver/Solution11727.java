package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution11727 {

    private static int[] memo = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(dp(Integer.parseInt(br.readLine())) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static int dp(int n) {
        memo[1] = 1;
        memo[2] = 3;

        for (int i = 3; i <= n; i++) {
            memo[i] = (2 * memo[i - 2] + memo[i - 1]) % 10007;
        }

        return memo[n];
    }
}