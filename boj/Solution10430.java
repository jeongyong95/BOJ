package boj;

import java.util.Scanner;

/*  나머지
    (A+B)%C는 (A%C + B%C)%C 와 같을까?
    (A×B)%C는 (A%C × B%C)%C 와 같을까?
    세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
    첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
    첫째 줄에 (A+B)%C, 둘째 줄에 (A%C + B%C)%C, 셋째 줄에 (A×B)%C, 넷째 줄에 (A%C × B%C)%C를 출력한다.
 */
public class Solution10430 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] number = new int[3];

        do {
            number[0] = scan.nextInt();
            number[1] = scan.nextInt();
            number[2] = scan.nextInt();
        } while (number[0] < 2 || number[2] > 10000);
        scan.close();

        int A = number[0], B = number[1], C = number[2];

        System.out.println((A + B) % C);
        System.out.println((A % C + B % C) % C);
        System.out.println((A * B) % C);
        System.out.println((A % C * B % C) % C);
    }
}