package toSolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution2108 {
    // 통계학
    // 생각하고 풀기
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] positiveArr = new int[4001];
        int[] negativeArr = new int[4001];

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(arr);
        int avg = (int) Arrays.stream(arr).average().getAsDouble();
        int centerNumber = arr[n / 2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                positiveArr[arr[i]]++;
            } else {
                negativeArr[Math.abs(arr[i])]++;
            }
        }

        int positiveMax = 0;
        int count = positiveArr[0];
        for (int i = 0; i < positiveArr.length; i++) {
            if (count < positiveArr[i]) {
                positiveMax = i;
                count = positiveArr[i];
            }

        }

        int range = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();

        bw.write(avg + "\n");

        bw.flush();
        bw.close();
    }
}
