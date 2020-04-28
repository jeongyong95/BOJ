import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  N과 M (3)
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    1부터 N까지 자연수 중에서 M개를 고른 수열
    같은 수를 여러 번 골라도 된다.
    첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
    중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class Solution15651 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        arr = new int[m];
        bufferedReader.close();

        dfs(n, m, 0);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static void dfs(int n, int m, int index) throws IOException {
        if (index == m) {
            for (int i = 0; i < arr.length; i++) {
                bufferedWriter.write(arr[i] + " ");
            }
            bufferedWriter.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[index] = i;
            dfs(n, m, index + 1);
        }
        return;
    }
}