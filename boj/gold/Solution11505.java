package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// TODO : 세그먼트 트리 학습하고 다시 오기
public class Solution11505 {
    static long DIV = 1_000_000_007l;
    static int n;
    static int[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        tree = new long[n + 1];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = 1l;
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            update(i, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                update(b, c);
                arr[b] = c;
            } else {
                long answer = multiply(c) / multiply(b - 1);
                sb.append(answer + "\n");
            }
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void update(int k, int newNumber) {
        int originNumber = arr[k];
        while (k <= n) {
            tree[k] /= originNumber;
            tree[k] *= newNumber;
            tree[k] %= DIV;
            k += k & -k;
        }
    }

    static long multiply(int k) {
        long result = 1l;
        while (k >= 1) {
            result *= tree[k];
            result %= DIV;
            k -= k & -k;
        }
        return result;
    }
}