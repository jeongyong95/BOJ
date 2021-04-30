import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2294 {
    static int INF = 10_001;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1];
        coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        bw.write(dp(k) + "\n");
        bw.flush();
        bw.close();
    }

    static int dp(int goal) {
        for (int i = 1; i <= goal; i++) {
            dp[i] = INF;
        }

        for (int i = 1; i <= goal; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i] > dp[i - coins[j]] + 1) {
                    dp[i] = dp[i - coins[j]] + 1;
                }
            }
        }

        if (dp[goal] == INF) {
            return -1;
        }
        return dp[goal];
    }
}
