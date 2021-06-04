package boj;

import java.util.Scanner;

/*  합
    n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
    첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
    1부터 n까지 합을 출력한다.
 */
public class Solution8393 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.close();
        int n, sum = 0;

        do {
            n = scan.nextInt();
        } while (n < 1 || n > 10000);

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}