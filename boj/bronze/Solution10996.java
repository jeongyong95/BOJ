package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  별 찍기 - 21
    예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
    첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
    첫째 줄부터 차례대로 별을 출력한다.
 */
public class Solution10996 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        for (int repeat = 1; repeat <= num; repeat++) {
            for (int i = 1; i <= 2; i++) {
                if (i % 2 != 0) {
                    for (int j = 1; j <= num; j++) {
                        if (j % 2 != 0) {
                            bufferedWriter.write("*");
                        }
                        if (j % 2 == 0) {
                            bufferedWriter.write(" ");
                        }
                    }
                }

                if (i % 2 == 0) {
                    for (int j = 1; j <= num; j++) {
                        if (j % 2 != 0) {
                            bufferedWriter.write(" ");
                        }
                        if (j % 2 == 0) {
                            bufferedWriter.write("*");
                        }
                    }
                }
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}