package boj.bronze;

import java.util.Scanner;

/*  A/B
    두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
    첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
    첫째 줄에 A/B를 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다.
 */
public class Solution1008 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A, B;

        do {
            A = scan.nextInt();
            B = scan.nextInt();
        } while (A < 0 || B > 10);
        scan.close();

        System.out.println((double) A / (double) B);
    }
}