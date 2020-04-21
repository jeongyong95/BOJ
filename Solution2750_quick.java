import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  수 정렬하기
    N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
    이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
    첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class Solution2750_quick {
    // 퀵정렬
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numberArray = new int[n];

        for (int i = 0; i < n; i++) {
            numberArray[i] = Integer.parseInt(bufferedReader.readLine());
        }
        bufferedReader.close();
        quickSort(numberArray, 0, numberArray.length - 1);

        for (int i = 0; i < n; i++) {
            bufferedWriter.write(numberArray[i] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static void quickSort(int[] arr, int start, int end) {
        int newStart = partition(arr, start, end);
        if (start < newStart - 1) {
            quickSort(arr, start, newStart - 1);
        }
        if (newStart < end) {
            quickSort(arr, newStart, end);
        }
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start < end + 1) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start < end + 1) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
            }
        }
        return start;
    }
}