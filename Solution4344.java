import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  평균은 넘겠지
    대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
    첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
    둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
    점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
    각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 */
public class Solution4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int count, testCase = Integer.parseInt(bufferedReader.readLine());
        Double[] avg = new Double[testCase], result = new Double[testCase];
        Double[][] scores = new Double[testCase][];

        for (int i = 0; i < testCase; i++) {
            String[] temp = bufferedReader.readLine().split(" ");
            count = Integer.parseInt(temp[0]);
            scores[i] = new Double[count];
            int sum = 0, avgCounter = 0;

            for (int j = 0; j < count; j++) {
                scores[i][j] = Double.parseDouble(temp[j + 1]);
                sum += scores[i][j];
            }
            avg[i] = (double) (sum / count);

            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] > avg[i]) {
                    avgCounter++;

                }
            }
            System.out.println(avgCounter);
            result[i] = (double) (avgCounter / count);
            System.out.println(result[i]);
        }
        bufferedReader.close();
        System.out.println(result[0]);
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}