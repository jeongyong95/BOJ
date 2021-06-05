package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution10972 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        if (getNextPermutation(arr)) {
            for (int i = 0; i < n; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
        } else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
    }

    static boolean getNextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
