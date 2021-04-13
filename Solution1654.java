import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(arr);

        long low = 1;
        long high = arr[k - 1];
        long mid = 0;

        while (low <= high) {
            int sum = 0;
            mid = (low + high) / 2;
            for (long l : arr) {
                sum += l / mid;
            }

            if (sum >= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        bw.write(high + "\n");
        bw.flush();
        bw.close();
    }
}