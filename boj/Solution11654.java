package boj;

import java.util.Scanner;

/*  아스키 코드
    알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
    알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.
    입력으로 주어진 글자의 아스키 코드 값을 출력한다.
 */
public class Solution11654 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String asc = scanner.nextLine();

        System.out.println((byte) asc.charAt(0));
        scanner.close();
    }
}