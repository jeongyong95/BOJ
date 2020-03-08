import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  달팽이는 올라가고 싶다
    땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
    달팽이는 낮에 A미터 올라갈 수 있다.
    하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
    달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
    첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
    첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
 */
public class Solution2869 {
    // 답지봤다ㅠㅠ 그리고 이분탐색으로 풀어야 한다. 복습 : 0회
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = bufferedReader.readLine();
        String[] strings = string.split(" ");

        long a = Integer.parseInt(strings[0]), b = Integer.parseInt(strings[1]), v = Integer.parseInt(strings[2]);
        bufferedReader.close();

        long result = (v - b - 1) / (a - b) + 1;
        bufferedWriter.write(result + "\n");
        bufferedWriter.close();
    }
}