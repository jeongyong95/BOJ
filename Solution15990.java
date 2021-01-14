import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution15990 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n;
        long[][] result = new long[100001][4];
        StringBuilder sb = new StringBuilder();

        result[1][1] = 1;
        result[2][2] = 1;
        result[3][1] = 1;
        result[3][2] = 1;
        result[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            result[i][1] = (result[i - 1][2] + result[i - 1][3]) % 1000000009;
            result[i][2] = (result[i - 2][1] + result[i - 2][3]) % 1000000009;
            result[i][3] = (result[i - 3][1] + result[i - 3][2]) % 1000000009;
        }

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append((result[n][1] + result[n][2] + result[n][3]) % 1000000009 + "\n");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}