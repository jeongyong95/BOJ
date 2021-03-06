package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  수 정렬하기 2
    N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
    이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
    첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class Solution2751_quick {
    // 퀵정렬
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }
        bufferedReader.close();
        quickSort(numbers, 0, numbers.length - 1);

        for (int integer : numbers) {
            bufferedWriter.write(integer + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static void quickSort(int[] arr, int start, int end) {
        int newEnd = partition(arr, start, end);
        if (start < newEnd - 1) {
            quickSort(arr, start, newEnd - 1);
        }
        if (newEnd < end) {
            quickSort(arr, newEnd, end);
        }
    }

    static int partition(int[] arr, int start, int end) {
        int temp, pivot = arr[(start + end) / 2];
        while (start < end + 1) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start < end + 1) {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
            }
        }
        return start;
    }
}