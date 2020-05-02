import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  피보나치 함수
    다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.
    int fibonacci(int n) {
        if (n == 0) {
            printf("0");
            return 0;
        } else if (n == 1) {
            printf("1");
            return 1;
        } else {
            return fibonacci(n‐1) + fibonacci(n‐2);
        }
    }
    fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
    fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
    fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
    두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
    fibonacci(0)은 0을 출력하고, 0을 리턴한다.
    fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
    첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
    fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
    1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 
    0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
 */
public class Solution1003 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] counter = new int[41][2];

    public static void main(String[] args) throws IOException {
        int n, t = Integer.parseInt(bufferedReader.readLine());
        fibo();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(bufferedReader.readLine());
            bufferedWriter.write(counter[n][0] + " " + counter[n][1] + "\n");
        }
        bufferedReader.close();

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static void fibo() {
        counter[0][0] = 1;
        counter[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            counter[i][0] = counter[i - 1][0] + counter[i - 2][0];
            counter[i][1] = counter[i - 1][1] + counter[i - 2][1];
        }
    }
}