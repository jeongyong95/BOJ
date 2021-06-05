package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution15649Repeat {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] checkArr;
    static int[] resultArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        checkArr = new boolean[nm[0] + 1];
        resultArr = new int[nm[1]];
        doRecursive(0, nm[0], nm[1]);
        bw.flush();
        bw.close();
    }

    public static void doRecursive(int index, int n, int m) throws IOException {
        if (index == m) {
            for (int i : resultArr) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (checkArr[i]) {
                continue;
            }
            checkArr[i] = true;
            resultArr[index] = i;
            doRecursive(index + 1, n, m);
            checkArr[i] = false;
        }
    }
}
