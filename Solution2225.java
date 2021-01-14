import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[][] result = new long[k + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            result[1][i] = 1;
        }
        for (int i = 1; i <= k; i++) {
            result[i][0] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int t = 0; t <= j; t++) {
                    result[i][j] += result[i - 1][j - t];
                    result[i][j] %= 1000000000;
                }
            }
        }
        bw.write(result[k][n] + "\n");
        bw.flush();
        bw.close();
    }
}
