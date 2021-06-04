package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution15663Reference {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] a = new int[10];
    static int[] resultArr = new int[10];
    static int[] cnt = new int[10];

    public static void main(String[] args) throws IOException {
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] candidateArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        Arrays.sort(candidateArr);

        int k = 0;
        int x = candidateArr[0];
        int c = 1;
        for (int i = 0; i < nm[0]; i++) {
            if (x == candidateArr[i]) {
                c++;
            } else {
                resultArr[k] = x;
                cnt[k] = c;
                k++;
                x = candidateArr[i];
                c = 1;
            }
        }
        resultArr[k] = x;
        cnt[k] = c;
        nm[0] = k + 1;

        go(0, nm[0], nm[1]);
        bw.flush();
        bw.close();
    }

    public static void go(int index, int n, int m) throws IOException {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                bw.write(resultArr[a[i]] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cnt[i] > 0) {
                cnt[i] -= 1;
                a[index] = i;
                go(index + 1, n, m);
                cnt[i] += 1;
            }
        }
    }
}
