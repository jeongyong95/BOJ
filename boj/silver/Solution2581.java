package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  소수
    자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 
    이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
    예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 
    소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
    입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
    M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
    M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 
    단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
 */
public class Solution2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int lowerNumber = Integer.parseInt(bufferedReader.readLine());
        int upperNumber = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        int[] numbers = new int[10001];
        int sum = 0, minimum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        numbers[0] = -1;
        numbers[1] = -1;

        for (int i = 2; i < 10001; i++) {
            for (int j = 2; i * j < 10001; j++) {
                if (numbers[i * j] == -1) {
                    continue;
                }
                numbers[i * j] = -1;
            }
        }

        for (int i = lowerNumber; i <= upperNumber; i++) {
            if (numbers[i] == -1) {
                continue;
            }

            if (minimum == 0) {
                minimum = numbers[i];
            }
            sum += numbers[i];
        }

        if (sum == 0) {
            sum = -1;
        }

        bufferedWriter.write(sum + "\n");

        if (sum != -1) {
            bufferedWriter.write(minimum + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}