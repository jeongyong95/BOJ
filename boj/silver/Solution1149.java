package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1149 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[1001][3];
        int[][] cost = new int[1001][3];

        for (int i = 0; i < cost.length; i++) {
            Arrays.fill(cost[i], 1001);
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        br.close();

        cost[1][0] = arr[1][0];
        cost[1][1] = arr[1][1];
        cost[1][2] = arr[1][2];

        for (int i = 2; i <= n; i++) {
            cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + arr[i][0];
            cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + arr[i][1];
            cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + arr[i][2];

        }

        bw.write(Math.min(cost[n][2], Math.min(cost[n][0], cost[n][1])) + "\n");
        bw.flush();
        bw.close();
    }
}
