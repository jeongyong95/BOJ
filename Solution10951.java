import java.util.ArrayList;
import java.util.Scanner;

/*  A+B - 4
    두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
    입력은 여러 개의 테스트 케이스로 이루어져 있다.
    각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
    각 테스트 케이스마다 A+B를 출력한다.
 */
public class Solution10951 {

    // 이것도 개선이 필요하다
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        ArrayList result = new ArrayList<Integer>();

        do {
            a = scanner.nextInt();
            b = scanner.nextInt();

            if (a <= 0 || b >= 10)
                break;

            result.add(a + b);

        } while (scanner.hasNextInt());

        for (Object object : result) {
            System.out.println(object);
        }

        scanner.close();
    }
}