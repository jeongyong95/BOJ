import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  동전 0
    준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
    동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
    첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
    둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
    첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
 */
public class Solution11047_chungAngVersion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(line[0]), k = Integer.parseInt(line[1]);
        int[] coins = new int[n];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }
        bufferedReader.close();

        bufferedWriter.write(greedy(coins, k) + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int greedy(int[] coins, int k) {
        int counter = 0;
        for (int i = coins.length - 1; i >= 0 || k != 0; i--) {
            if (k >= coins[i]) {
                counter += k / coins[i];
                k %= coins[i];
            }
        }
        return counter;
    }
}