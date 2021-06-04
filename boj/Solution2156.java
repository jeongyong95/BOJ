package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution2156 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        dp[1] = arr[1];
        int max = dp[1];

        if (n > 1) {
            dp[2] = arr[1] + arr[2];

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1];

                if (dp[i] < dp[i - 2] + arr[i]) {
                    dp[i] = dp[i - 2] + arr[i];
                }

                if (dp[i] < dp[i - 3] + arr[i - 1] + arr[i]) {
                    dp[i] = dp[i - 3] + arr[i - 1] + arr[i];
                }
            }

            for (int i : dp) {
                if (max < i) {
                    max = i;
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
