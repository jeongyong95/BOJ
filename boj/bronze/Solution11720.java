package boj.bronze;

import java.math.BigInteger;
import java.util.Scanner;

/*  숫자의 합
    N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
    첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
    입력으로 주어진 숫자 N개의 합을 출력한다.
 */
public class Solution11720 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersLength = scanner.nextInt();
        String numberString = "";

        do {
            numberString = scanner.next();
        } while (numberString.length() > numbersLength);

        System.out.println(sum(numberString));
        scanner.close();
    }

    static BigInteger sum(String numberString) {
        BigInteger remainder, result = BigInteger.valueOf(0), number = new BigInteger(numberString);

        for (int i = 0; i < numberString.length(); i++) {
            remainder = number.remainder(BigInteger.valueOf(10));
            result = result.add(remainder);
            number = number.divide(BigInteger.valueOf(10));
        }

        return result;
    }
}