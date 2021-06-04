package boj;

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
        int c = Integer.parseInt(bufferedReader.readLine());
        int[][] studentScores = new int[c][];
        float[] result = new float[c];

        for (int i = 0; i < studentScores.length; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            studentScores[i] = new int[line.length];
            for (int j = 0; j < studentScores[i].length; j++) {
                studentScores[i][j] = Integer.parseInt(line[j]);
            }
            result[i] = function(studentScores[i]);
        }
        bufferedReader.close();

        for (float f : result) {
            bufferedWriter.write(String.format("%.3f", f * 100) + "%\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static float function(int[] scores) {
        int sum = 0, pass = 0;
        float avg = 0;

        for (int i = 1; i < scores.length; i++) {
            sum += scores[i];
        }

        avg = (float) sum / scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > avg) {
                pass++;
            }
        }
        return (float) pass / (scores.length - 1);
    }
}