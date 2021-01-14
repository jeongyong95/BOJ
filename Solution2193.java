import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution2193 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();
        long[][] arr = new long[91][2];

        arr[1][1] = 1;

        for (int i = 2; i <= 90; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i - 1][1];
            arr[i][1] = arr[i - 1][0];
        }

        bw.write(arr[n][0] + arr[n][1] + "\n");
        bw.flush();
        bw.close();
    }
}
