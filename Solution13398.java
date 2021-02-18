import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution13398 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        int[] dpl = new int[n];
        int[] dpr = new int[n];
        dpl[0] = arr[0];
        dpr[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            dpl[i] = arr[i];

            if (dpl[i] < dpl[i - 1] + arr[i]) {
                dpl[i] = dpl[i - 1] + arr[i];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            dpr[i] = arr[i];
            if (dpr[i] < dpr[i + 1] + arr[i]) {
                dpr[i] = dpr[i + 1] + arr[i];
            }
        }

        int max = dpl[0];
        for (int i : dpl) {
            if (max < i) {
                max = i;
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (max < dpl[i - 1] + dpr[i + 1]) {
                max = dpl[i - 1] + dpr[i + 1];
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}