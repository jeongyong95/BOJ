package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*  N과 M (6)
    N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    N개의 자연수는 모두 다른 수이다. N개의 자연수 중에서 M개를 고른 수열. 고른 수열은 오름차순이어야 한다.
    첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
    둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
    중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class Solution15655 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] checker;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        int[] input = new int[n];
        checker = new boolean[n];
        arr = new int[m];

        line = bufferedReader.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(line[i]);
        }
        bufferedReader.close();
        Arrays.sort(input);

        backTracking(input, m, 0);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static void backTracking(int[] input, int m, int index) throws IOException {
        if (index == m) {
            for (int i = 0; i < arr.length; i++) {
                bufferedWriter.write(arr[i] + " ");
            }
            bufferedWriter.write("\n");
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (checker[i]) {
                continue;
            }
            checker[i] = true;
            arr[index] = input[i];
            if (index == 0) {
                backTracking(input, m, index + 1);
            }
            if (index != 0 && arr[index] > arr[index - 1]) {
                backTracking(input, m, index + 1);
            }
            checker[i] = false;
        }
        return;
    }
}