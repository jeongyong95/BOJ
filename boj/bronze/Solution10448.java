package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution10448 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] tArr = new int[51];

    public static void main(String[] args) throws NumberFormatException, IOException {
        for (int i = 1; i < tArr.length; i++) {
            tArr[i] = tArr[i - 1] + i;
        }

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int number = Integer.parseInt(br.readLine());
            bw.write(isPossible(number) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static int isPossible(int number) {
        for (int i = 1; i < tArr.length; i++) {
            for (int j = 1; j < tArr.length; j++) {
                for (int k = 1; k < tArr.length; k++) {
                    if (number == tArr[i] + tArr[j] + tArr[k]) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

}
