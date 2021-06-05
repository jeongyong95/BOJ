package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][n + 1];
        int[][] prefixSum = new int[n + 1][n + 1];

        for (int i = 1; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = map[i][j];
            }
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                prefixSum[i][j] += prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
            sb.append(result + "\n");
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
