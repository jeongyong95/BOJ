import java.util.Scanner;

/*  곱셈
    (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
    (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
    첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
    첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다. 
 */
public class Solution2588 {

    public static void main(String[] args) {
        int firstNumber, secondNumber;
        Scanner scan = new Scanner(System.in);

        firstNumber = scan.nextInt();
        secondNumber = scan.nextInt();

        System.out.println(firstNumber * (secondNumber % 10));
        System.out.println(firstNumber * (secondNumber % 100 / 10));
        System.out.println(firstNumber * (secondNumber / 100));
        System.out.println(firstNumber * secondNumber);

        scan.close();
    }
}