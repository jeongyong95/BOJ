package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][m + 1];
        int[][] sum = new int[n + 1][m + 1];

        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[i].length; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = sum[x][y] + sum[i - 1][j - 1] - sum[i - 1][y] - sum[x][j - 1];
            sb.append(result + "\n");
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}