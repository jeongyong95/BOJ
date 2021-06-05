package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  정수 삼각형
    위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
    맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 
    이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라.
    아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
    삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
    첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.
    첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
 */
public class Solution1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] triangle = new int[n + 1][];
        int[][] cache = new int[n + 1][];

        for (int i = 1; i < triangle.length; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            triangle[i] = new int[i + 1];
            for (int j = 0; j < i; j++) {
                triangle[i][j + 1] = Integer.parseInt(line[j]);
            }
        }
        bufferedReader.close();

        bufferedWriter.write(dp(triangle, cache, n) + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int dp(int[][] arr, int[][] cache, int n) {
        int maxSum = 0;
        for (int i = 1; i < cache.length; i++) {
            cache[i] = new int[i + 1];
            for (int j = 1; j <= i; j++) {
                if (i == 1 && j == 1) {
                    cache[1][1] = arr[1][1];
                    continue;
                }
                if (j == 1) {
                    cache[i][j] = cache[i - 1][1] + arr[i][1];
                    continue;
                }
                if (i == j) {
                    cache[i][j] = cache[i - 1][j - 1] + arr[i][j];
                    continue;
                }
                cache[i][j] = Math.max(cache[i - 1][j - 1], cache[i - 1][j]) + arr[i][j];
            }
        }

        for (int i = 1; i < cache[n].length; i++) {
            if (maxSum < cache[n][i]) {
                maxSum = cache[n][i];
            }
        }
        return maxSum;
    }
}