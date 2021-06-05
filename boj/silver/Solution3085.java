package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution3085 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        br.close();

        // 순회 검사
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    char swapTemp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = swapTemp;

                    int answerTemp = getAnswer(arr);
                    if (answer < answerTemp) {
                        answer = answerTemp;
                    }

                    swapTemp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = swapTemp;
                }

                if (i + 1 < n) {
                    char swapTemp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = swapTemp;

                    int answerTemp = getAnswer(arr);
                    if (answer < answerTemp) {
                        answer = answerTemp;
                    }

                    swapTemp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = swapTemp;
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static int getAnswer(char[][] arr) {
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {

            int cnt = 1;
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (answer < cnt) {
                    answer = cnt;
                }
            }

            cnt = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1][i] == arr[j][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (answer < cnt) {
                    answer = cnt;
                }
            }
        }
        return answer;
    }
}
