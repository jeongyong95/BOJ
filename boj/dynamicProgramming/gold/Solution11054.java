package boj.dynamicProgramming.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution11054 {
    // 각 배열 요소의 값을 넣어줄 때, 반드시 현존값과 비교하고 더 큰 값을 선택하자
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        // [0][n] : 증가수열 길이, [1][n] : 감소수열 길이,[2][n] : 바이토닉 수열 길이
        int[][] dp = new int[3][n];
        for (int[] is : dp) {
            Arrays.fill(is, 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[0][i] < dp[0][j] + 1) {
                    dp[0][i] = dp[0][j] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && dp[1][i] < dp[1][j] + 1) {
                    dp[1][i] = dp[1][j] + 1;
                }
            }
        }

        int max = 1;

        for (int i = 0; i < n; i++) {
            dp[2][i] = dp[0][i] + dp[1][i] - 1;
            if (max < dp[2][i]) {
                max = dp[2][i];
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
