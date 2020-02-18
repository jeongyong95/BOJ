import java.util.Scanner;

/*  A+B - 7
    두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
    첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
    각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.
 */
public class Solution11021 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, t, i = 1;

        do {
            t = scan.nextInt();
        } while (t < 1);

        int[] result = new int[t];

        for (int j = 0; j < t; j++) {
            do {
                a = scan.nextInt();
                b = scan.nextInt();
            } while (a <= 0 || b >= 10);
            result[j] = a + b;
        }

        for (int j : result) {
            System.out.println("Case #" + i + ": " + j);
            i++;
        }

        scan.close();
    }
}