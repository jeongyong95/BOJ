package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Solution2042
 */
public class Solution2042 {
    static int n;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];
        tree = new long[n + 1];
        for (int i = 1; i < arr.length; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i] = num;
            add(i, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                add(b, c - arr[b]);
                arr[b] = c;
            } else {
                long result = sum((int) c) - sum(b - 1);
                sb.append(result + "\n");
            }
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static long sum(int k) {
        long s = 0;
        while (k >= 1) {
            s += tree[k];
            k -= k & -k;
        }
        return s;
    }

    static void add(int k, long x) {
        while (k <= n) {
            tree[k] += x;
            k += k & -k;
        }
    }
}