package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  수 정렬하기 3
    N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
    이 수는 10,000보다 작거나 같은 자연수이다.
    첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class Solution10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine()), maxNumber = 0;
        int[] numbers = new int[n], result;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }
        bufferedReader.close();
        result = countingSort(numbers, maxNumber);
        for (int i : result) {
            bufferedWriter.write(i + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int[] countingSort(int[] arr, int maxNumber) {
        int[] accumSum = new int[maxNumber + 1], countNumber = new int[maxNumber + 1];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            countNumber[arr[i]]++;
        }
        accumSum[0] = countNumber[0];

        for (int i = 1; i < accumSum.length; i++) {
            accumSum[i] = accumSum[i - 1] + countNumber[i];
        }

        for (int i = result.length - 1; i > -1; i--) {
            result[accumSum[arr[i]] - 1] = arr[i];
            accumSum[arr[i]]--;
        }
        return result;
    }
}