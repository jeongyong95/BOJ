import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution9095 {

    private static int[] d = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            bw.write(dp(Integer.parseInt(br.readLine())) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static int dp(int n) {
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        if (n > 3) {
            for (int i = 4; i <= n; i++) {
                d[i] = d[i - 1] + d[i - 2] + d[i - 3];
            }
        }
        return d[n];
    }
}
