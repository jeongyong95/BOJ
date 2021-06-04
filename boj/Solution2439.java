package boj;

import java.util.Scanner;

/*  별 찍기 - 2
    첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
    하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
    첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
    첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
 */
public class Solution2439 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, count = 1;

        do {
            n = scan.nextInt();
        } while (n < 1 || n > 100);

        while (n > 0) {
            for (int i = 1; i < n; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= count; i++) {
                System.out.print("*");
            }
            System.out.println();
            count++;
            n--;
        }

        scan.close();
    }
}