import java.util.Scanner;

/*  세 수
    세 정수 A, B, C가 주어진다. 이때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오.
    첫째 줄에 세 정수 A, B, C가 공백으로 구분되어 주어진다. (1 ≤ A, B, C ≤ 100)
    두 번째로 큰 정수를 출력한다.
 */
public class Solution10817 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, c, second;

        do {
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
        } while (a < 1 && c > 100);

        second = a > (b > c ? b : c) ? (b > c ? b : c) : a > (b > c ? c : b) ? a : (b > c ? c : b);

        System.out.println(second);

        scan.close();
    }
}