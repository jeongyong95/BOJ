import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solution15988
 */
public class Solution15988 {
    static long[][] arr = new long[1000001][4];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr[1][1] = 1;
        arr[2][1] = 1;
        arr[2][2] = 1;
        arr[3][1] = 2;
        arr[3][2] = 1;
        arr[3][3] = 1;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            // dp
            sb.append(dp(n) + "\n");
        }
        br.close();
        System.out.println(sb.toString());
    }

    public static long dp(int n) {
        for (int i = 4; i <= n; i++) {
            arr[i][1] = (arr[i - 1][1] + arr[i - 1][2] + arr[i - 1][3]) % 1000000009;
            arr[i][2] = (arr[i - 2][1] + arr[i - 2][2] + arr[i - 2][3]) % 1000000009;
            arr[i][3] = (arr[i - 3][1] + arr[i - 3][2] + arr[i - 3][3]) % 1000000009;
        }
        return (arr[n][1] + arr[n][2] + arr[n][3]) % 1000000009;
    }
}