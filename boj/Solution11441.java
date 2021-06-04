package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Solution11441
 */
public class Solution11441 {
    static int n;
    static int[] tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        tree = new int[n + 1];

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            update(i, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = sum(end) - sum(start - 1);
            sb.append(result + "\n");
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void update(int k, int diff) {
        while (k <= n) {
            tree[k] += diff;
            k += k & -k;
        }
    }

    static int sum(int k) {
        int result = 0;
        while (k >= 1) {
            result += tree[k];
            k -= k & -k;
        }
        return result;
    }
}