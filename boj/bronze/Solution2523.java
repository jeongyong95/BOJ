package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  별 찍기 - 13
    예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
    첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
    첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
 */
public class Solution2523 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int maximumStar = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        for (int i = 0; i < maximumStar; i++) {
            for (int j = 0; j <= i; j++) {
                bufferedWriter.write("*");
            }
            bufferedWriter.write("\n");
        }

        for (int i = maximumStar - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                bufferedWriter.write("*");
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}