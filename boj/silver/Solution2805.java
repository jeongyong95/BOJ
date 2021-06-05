package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Arrays.sort(arr);

        int low = 1;
        int high = arr[n - 1];
        int mid = 0;
        while (low <= high) {
            long sum = 0;
            mid = (low + high) / 2;

            for (int i = 0; i < n; i++) {
                if (arr[i] >= mid) {
                    sum += (arr[i] - mid);
                }
            }

            if (sum >= m) {
                low = mid + 1;
            } else if (sum < m) {
                high = mid - 1;
            }
        }
        bw.write(high + "\n");
        bw.flush();
        bw.close();
    }
}
