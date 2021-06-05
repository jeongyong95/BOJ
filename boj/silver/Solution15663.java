package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Set<String> resultSet = new LinkedHashSet<>();
    static boolean[] checkArr;
    static int[] candidateArr;
    static int[] resultArr;

    public static void main(String[] args) throws IOException {

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        candidateArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        Arrays.sort(candidateArr);
        resultArr = new int[nm[1]];
        checkArr = new boolean[nm[0]];
        doRecursive(0, nm[0], nm[1]);
        bw.flush();
        bw.close();
    }

    public static void doRecursive(int index, int n, int m) throws IOException {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : resultArr) {
                sb.append(i + " ");
            }
            sb.trimToSize();
            sb.append("\n");
            String result = sb.toString();
            if (!resultSet.contains(result)) {
                resultSet.add(result);
                bw.write(result);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checkArr[i]) {
                continue;
            }
            if (index == 0 && (i > 0 && candidateArr[i - 1] == candidateArr[i])) {
                continue;
            }
            resultArr[index] = candidateArr[i];
            checkArr[i] = true;
            doRecursive(index + 1, n, m);
            checkArr[i] = false;
        }
    }
}