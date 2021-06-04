package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution11659 {
    static int n;

    // Binary Indexed Tree
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        tree = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            update(i, arr[i]);
        }

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
