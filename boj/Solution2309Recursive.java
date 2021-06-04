package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution2309Recursive {

    static int answer = 0;
    static int number = 0;
    static boolean solvedFlag = false;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        boolean[] checkArr = new boolean[9];
        int[] answerArr = new int[9];

        for (int i = 0; i < checkArr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        backTracking(arr, checkArr, 0);

        for (int i = 0; i < checkArr.length; i++) {
            if (checkArr[i] == true) {
                answerArr[i] = arr[i];
            }
        }
        Arrays.sort(answerArr);
        for (int i = 0; i < answerArr.length; i++) {
            if (answerArr[i] != 0) {
                bw.write(answerArr[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void backTracking(int[] arr, boolean[] checkArr, int index) {
        if (answer == 100 && number == 7) {
            solvedFlag = true;
            return;
        }

        for (int i = index; i < arr.length; i++) {
            answer += arr[i];
            checkArr[i] = true;
            number += 1;

            if (answer <= 100) {
                backTracking(arr, checkArr, i + 1);
            }

            if (solvedFlag) {
                return;
            }
            answer -= arr[i];
            checkArr[i] = false;
            number -= 1;
        }
    }
}