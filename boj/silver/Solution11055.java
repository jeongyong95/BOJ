package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution11055 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        int[] dp = Arrays.copyOf(arr, arr.length);

        for (int i = 1; i < a; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }

        int max = dp[0];
        for (int i : dp) {
            if (max <= i) {
                max = i;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
