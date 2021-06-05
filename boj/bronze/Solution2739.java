package boj.bronze;

import java.util.Scanner;

/*  구구단
    N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.
    첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 9보다 작거나 같다.
    출력형식과 같게 N*1부터 N*9까지 출력한다.
 */
public class Solution2739 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;

        do {
            n = scan.nextInt();
        } while (n > 9 || n < 1);
        scan.close();

        for (int i = 1; i <= 9; i++) {
            System.out.println(n + " * " + i + " = " + n * i);
        }
    }
}