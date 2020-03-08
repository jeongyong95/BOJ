import java.util.Scanner;

/*  분수찾기
    무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
    1/1	1/2	1/3	1/4	1/5	…
    2/1	2/2	2/3	2/4	…	…
    3/1	3/2	3/3	…	…	…
    4/1	4/2	…	…	…	…
    5/1	…	…	…	…	…
    …	…	…	…	…	…
    이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 
    차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
    X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
    첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
    첫째 줄에 분수를 출력한다.
 */
public class Solution1193 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();
        int level = 1, sum = 0;

        do {
            sum += level;
            if (level * (level - 1) / 2 >= x) {
                sum -= level * 2 - 1;
                level--;
                break;
            }
            level++;
        } while (true);

        if (level % 2 == 0) {
            System.out.println((x - sum) + "/" + (level + 1 - x + sum));
        }
        if (level % 2 != 0) {
            System.out.println((level + 1 - x + sum) + "/" + (x - sum));
        }

    }
}