import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  1로 만들기
    정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
    X가 3으로 나누어 떨어지면, 3으로 나눈다. X가 2로 나누어 떨어지면, 2로 나눈다. 1을 뺀다.
    정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
    첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
    첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */
public class Solution1463 {
    // bottom-up으로 풀어야 한다. (반복문 사용)
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        bufferedWriter.write(dp(n) + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int dp(int n) {
        int[] cache = new int[n + 1];
        cache[1] = 0;
        for (int i = 2; i < cache.length; i++) {
            cache[i] = cache[i - 1] + 1;
            if (i % 2 == 0) {
                cache[i] = Math.min(cache[i], cache[i / 2] + 1);
            }
            if (i % 3 == 0) {
                cache[i] = Math.min(cache[i], cache[i / 3] + 1);
            }
        }
        return cache[n];
    }
}