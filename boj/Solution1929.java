package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  소수 구하기
    M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
    첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)
    한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 */
public class Solution1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputLimitNumber = bufferedReader.readLine().split(" ");
        bufferedReader.close();

        int[] limitNumbers = new int[2];
        limitNumbers[0] = Integer.parseInt(inputLimitNumber[0]);
        limitNumbers[1] = Integer.parseInt(inputLimitNumber[1]);

        int[] primeNumbers = new int[limitNumbers[1] + 1];
        for (int i = limitNumbers[0]; i < limitNumbers[1] + 1; i++) {
            primeNumbers[i] = i;
        }
        primeNumbers[1] = 0;

        for (int i = 2; i < primeNumbers.length; i++) {
            for (int j = i * 2; j < primeNumbers.length; j += i) {
                if (primeNumbers[j] == 0) {
                    continue;
                }

                primeNumbers[j] = 0;
            }
        }

        for (int i = limitNumbers[0]; i <= limitNumbers[1]; i++) {
            if (primeNumbers[i] != 0) {
                bufferedWriter.write(primeNumbers[i] + "\n");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}