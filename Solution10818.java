import java.util.Scanner;

/*  최소, 최대
    N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
    첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
    둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
    모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
    첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
 */
public class Solution10818 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, min, max;
        int[] array;

        do {
            n = scanner.nextInt();
        } while (n < 1 || n > 1000000);

        array = new int[n];

        for (int i = 0; i < array.length; i++) {
            do {
                array[i] = scanner.nextInt();
            } while (array[i] < -1000000 || array[i] > 1000000);
        }

        min = array[0];
        max = array[0];

        for (int j = 1; j < array.length; j++) {
            min = min < array[j] ? min : array[j];
            max = max > array[j] ? max : array[j];
        }

        System.out.println(min + " " + max);

        scanner.close();
    }
}