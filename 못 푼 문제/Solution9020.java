import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*  골드바흐의 추측
    1보다 큰 자연수 중에서 1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다.
    예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.
    골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다.
    이러한 수를 골드바흐 수라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다.
    예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다.
    10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.
    2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오.
    만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.
    첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    각 테스트 케이스는 한 줄로 이루어져 있고 짝수 n이 주어진다. (4 ≤ n ≤ 10,000)
    각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력한다.
    출력하는 소수는 작은 것부터 먼저 출력하며, 공백으로 구분한다.
 */
public class Solution9020 {
    // 못풀었다;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        int[] tests = new int[testCase], primeNumbers = new int[10001];

        for (int i = 0; i < testCase; i++) {
            tests[i] = Integer.parseInt(bufferedReader.readLine());
        }
        bufferedReader.close();

        for (int i = 0; i < primeNumbers.length; i++) {
            primeNumbers[i] = i;
        }
        primeNumbers[0] = 0;
        primeNumbers[1] = 0;

        for (int i = 2; i < primeNumbers.length; i++) {
            for (int j = i * 2; j < primeNumbers.length; j += i) {
                if (primeNumbers[j] == 0) {
                    continue;
                }
                primeNumbers[j] = 0;
            }
        }

        for (int i : tests) {
            int findedIndex = Arrays.binarySearch(primeNumbers, i);
            if (findedIndex >= 0) {
                System.out.println(i + "/2의 인덱스는 " + findedIndex + "입니다.");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}