package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution2503 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][];
        boolean[] rangeArr = new boolean[988];
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k < 10; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    rangeArr[Integer.valueOf(new StringBuilder().append(i).append(j).append(k).toString())] = true;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        int strike = 0;
        int ball = 0;

        for (int i = 123; i < rangeArr.length; i++) {
            if (rangeArr[i]) {
                for (int j = 0; j < arr.length; j++) {
                    String[] rangeNumber = String.valueOf(i).split("");
                    String[] number = String.valueOf(arr[j][0]).split("");

                    for (int k = 0; k < rangeNumber.length; k++) {
                        if (String.valueOf(arr[j][0]).contains(rangeNumber[k])) {
                            ball++;
                            if (number[k].equals(rangeNumber[k])) {
                                strike++;
                            }
                        }
                    }
                    ball -= strike;

                    if (arr[j][1] != strike || arr[j][2] != ball) {
                        rangeArr[i] = false;
                    }
                    strike = 0;
                    ball = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 123; i < rangeArr.length; i++) {
            if (rangeArr[i]) {
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
