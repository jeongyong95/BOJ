package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        Arrays.sort(arr);
        int answer = arr[2];
        while (true) {
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                if (answer % arr[i] == 0) {
                    count++;
                }

                if (count == 3) {
                    bw.write(answer + "\n");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
            answer++;
        }
    }
}
