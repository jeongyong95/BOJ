package boj.silver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/*  소수 찾기
    주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
    첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
    주어진 수들 중 소수의 개수를 출력한다.
 */
public class Solution1978 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int counter = 0, n = scanner.nextInt();
        int[] nArray = new int[n];

        for (int i = 0; i < nArray.length; i++) {
            nArray[i] = scanner.nextInt();
        }
        scanner.close();

        Boolean[] primeNumbers = new Boolean[1001];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;

        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; i * j <= 1000; j++) {
                if (primeNumbers[i * j] == false) {
                    continue;
                }
                primeNumbers[i * j] = false;
            }
        }

        for (int i : nArray) {
            if (primeNumbers[i] == true) {
                counter++;
            }
        }

        bufferedWriter.write(counter + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}