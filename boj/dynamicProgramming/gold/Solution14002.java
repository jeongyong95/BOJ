package boj.dynamicProgramming.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution14002 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        int resultIndex = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lenArr = new int[n];
        int[] previousIndexArr = new int[n];
        br.close();

        for (int i = 0; i < n; i++) {
            lenArr[i] = 1;
            previousIndexArr[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lenArr[i] < lenArr[j] + 1) {
                    lenArr[i] = lenArr[j] + 1;
                    previousIndexArr[i] = j;
                }
            }
            if (result < lenArr[i]) {
                result = lenArr[i];
                resultIndex = i;
            }
        }
        bw.write(result + "\n");
        bw.write(printArr(resultIndex, previousIndexArr, arr).toString() + "\n");
        bw.flush();
        bw.close();
    }

    static StringBuilder printArr(int currentIndex, int[] previousIndexArr, int[] arr) {
        if (currentIndex == previousIndexArr[currentIndex]) {
            return new StringBuilder(arr[currentIndex] + " ");
        }

        return printArr(previousIndexArr[currentIndex], previousIndexArr, arr).append(arr[currentIndex] + " ");
    }
}