package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  N과 M (1)
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
    중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class Solution15649 {
    // 백트래킹 dfs 이용
    // 어렵지만 할 수 있다!
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] numbers;
    static boolean[] checker;

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");
        bufferedReader.close();
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        numbers = new int[m];
        checker = new boolean[n + 1];
        backTracking(n, m, 0);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static void backTracking(int n, int m, int d) throws IOException {
        if (m == d) {
            for (Integer integer : numbers) {
                bufferedWriter.write(integer + " ");
            }
            bufferedWriter.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!checker[i]) {
                checker[i] = true;
                numbers[d] = i;
                backTracking(n, m, d + 1);
                checker[i] = false;
            }
        }
        return;
    }
}