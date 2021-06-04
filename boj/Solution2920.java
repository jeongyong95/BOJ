package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        boolean ascending = false;
        boolean descending = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                ascending = true;
            }
            if (arr[i] < arr[i - 1]) {
                descending = true;
            }
        }

        if (ascending && !descending) {
            bw.write("ascending\n");
        } else if (!ascending && descending) {
            bw.write("descending\n");
        } else {
            bw.write("mixed\n");
        }
        bw.flush();
        bw.close();
    }
}
