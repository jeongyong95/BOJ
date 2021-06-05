package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution11053 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] inputArr = br.readLine().split(" ");
        int[] arr = Arrays.stream(inputArr).mapToInt(Integer::parseInt).toArray();
        int[] lisLengthArr = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            lisLengthArr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lisLengthArr[i] = Math.max(lisLengthArr[i], lisLengthArr[j] + 1);
                }
            }
            if (result < lisLengthArr[i]) {
                result = lisLengthArr[i];
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
