import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution11052 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        int[] p = new int[n + 1];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 1; i < p.length; i++) {
            p[i] = Integer.parseInt(tokenizer.nextToken());
        }
        d[0] = p[0];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i - j] + p[j]);
            }
        }

        bw.write(d[n] + "\n");
        bw.flush();
        bw.close();
    }
}