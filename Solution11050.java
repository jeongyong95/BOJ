import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k < 0 || k > n) {
            bw.write(0 + "\n");
        } else {
            int child = 1;
            for (int i = 1; i <= n; i++) {
                child *= i;
            }
            int parent = 1;
            for (int i = 1; i <= k; i++) {
                parent *= i;
            }
            for (int i = 1; i <= n - k; i++) {
                parent *= i;
            }
            bw.write(child / parent + "\n");
        }
        bw.flush();
        bw.close();
    }
}
