import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1309 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        long[][] arr = new long[100001][3];
        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[1][2] = 1;

        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                arr[i][0] = (arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2]) % 9901;
                arr[i][1] = (arr[i - 1][0] + arr[i - 1][2]) % 9901;
                arr[i][2] = (arr[i - 1][0] + arr[i - 1][1]) % 9901;
            }
        }
        bw.write((arr[n][0] + arr[n][1] + arr[n][2]) % 9901 + "\n");
        bw.flush();
        bw.close();
    }
}
