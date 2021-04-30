import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution11048 {
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        for (int i = 1; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = map[i][j];
            }
        }
        br.close();

        dp();
        bw.write(dp[n][m] + "\n");
        bw.flush();
        bw.close();

    }

    static void dp() {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (dp[i][j] < dp[i - 1][j] + map[i][j]) {
                    dp[i][j] = dp[i - 1][j] + map[i][j];
                }
                if (dp[i][j] < dp[i][j - 1] + map[i][j]) {
                    dp[i][j] = dp[i][j - 1] + map[i][j];
                }
            }
        }
    }
}