package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1912 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        int[] sumArr = new int[n];
        int result = arr[0];
        sumArr[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sumArr[i] = arr[i];
            if (sumArr[i - 1] + arr[i] > sumArr[i]) {
                sumArr[i] = sumArr[i - 1] + arr[i];
            }
            if (result < sumArr[i]) {
                result = sumArr[i];
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
