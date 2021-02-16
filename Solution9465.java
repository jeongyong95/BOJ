import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution9465 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[3][n];
            int[][] result = new int[3][n];

            for (int i = 1; i <= 2; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            result[0][0] = 0;
            result[1][0] = arr[1][0];
            result[2][0] = arr[2][0];

            for (int i = 1; i < n; i++) {
                result[0][i] = Math.max(result[0][i - 1], Math.max(result[1][i - 1], result[2][i - 1]));
                result[1][i] = Math.max(result[0][i - 1] + arr[1][i], result[2][i - 1] + arr[1][i]);
                result[2][i] = Math.max(result[0][i - 1] + arr[2][i], result[1][i - 1] + arr[2][i]);
            }
            bw.write(Math.max(result[0][n - 1], Math.max(result[1][n - 1], result[2][n - 1])) + "\n");
        }
        bw.flush();
        bw.close();
    }
}