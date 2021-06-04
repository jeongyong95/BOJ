package boj;

import java.util.Scanner;

/*  한수
    어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다.
    등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
    N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
    첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
    첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 */
public class Solution1065 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(findOne(n));
        scanner.close();
    }

    static int findOne(int number) {
        int temp = number, counter = 0;
        if (temp < 100) {
            return temp;
        }
        for (int i = 100; i <= number; i++) {
            if (i / 100 - i % 100 / 10 == i % 100 / 10 - i % 10) {
                counter++;
            }
        }
        return counter + 99;
    }
}