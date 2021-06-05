package boj.bronze;

import java.util.Scanner;

/*  A-B
    두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오. 첫째 줄에 A와 B가 주어진다. (0 < A, B< 10)
 */
public class Solution1001 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A, B;

        do {
            A = scan.nextInt();
            B = scan.nextInt();
        } while (A < 0 || B > 10);
        scan.close();

        System.out.println(A - B);
    }
}