package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution14697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        for (int i = 0; i <= arr[3]; i += arr[0]) {
            for (int j = 0; j <= arr[3] - i; j += arr[1]) {
                for (int k = 0; k <= arr[3] - i - j; k += arr[2]) {
                    if (arr[3] - i - j - k == 0) {
                        bw.write(1 + "\n");
                        bw.flush();
                        bw.close();
                        return;
                    }
                }
            }
        }
        bw.write(0 + "\n");
        bw.flush();
        bw.close();
    }
}
