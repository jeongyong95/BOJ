package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution6064 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[2] -= 1;
            arr[3] -= 1;
            int result = -1;
            for (int i = arr[2]; i < arr[0] * arr[1]; i += arr[0]) {
                if (i % arr[1] == arr[3]) {
                    result = i + 1;
                    break;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}