import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution10164 {
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        dp = new long[n][m];

        if (k != 0) {
            int col = (k - 1) % m;
            int row = (k - 1) / m;

            for (int i = 0; i <= row; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i <= col; i++) {
                dp[0][i] = 1;
            }

            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }

            for (int i = row; i < n; i++) {
                dp[i][col] = dp[row][col];
            }
            for (int i = col; i < m; i++) {
                dp[row][i] = dp[row][col];
            }

            for (int i = row + 1; i < n; i++) {
                for (int j = col + 1; j < m; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < m; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        bw.write(dp[n - 1][m - 1] + "\n");
        bw.flush();
        bw.close();
    }
}
