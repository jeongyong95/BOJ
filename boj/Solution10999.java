package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution10999 {
    static int n;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        tree = new long[n + 1];
        long[] arr = new long[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Long.parseLong(br.readLine());
            update(i, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            long d = 0;

            if (st.hasMoreTokens()) {
                d = Long.parseLong(st.nextToken());
            }

            if (a == 1) {
                for (int j = b; j <= c; j++) {
                    update(j, d);
                    arr[j] += d;
                }
            } else {
                long result = sum(c) - sum(b - 1);
                sb.append(result + "\n");
            }
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static long sum(int k) {
        long result = 0;
        while (k >= 1) {
            result += tree[k];
            k -= k & -k;
        }
        return result;
    }

    static void update(int k, long diff) {
        while (k <= n) {
            tree[k] += diff;
            k += k & -k;
        }
    }
}