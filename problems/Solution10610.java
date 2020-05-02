package problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  30
    어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에, 
    그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
    미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.
    N을 입력받는다. N는 최대 105개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.
    미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.
 */
public class Solution10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // 미르코가 찾은 수
        String n = bufferedReader.readLine();
        bufferedReader.close();

        // 미르코는 30을 존경함
        bufferedWriter.write(greedy(n) + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int greedy(String n) {
        int limit = 1;

        for (int i = 1; i <= n.length(); i++) {
            limit *= i;
        }

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '0') {
                limit--;
            }
        }

        while (limit != 0) {

            limit--;
        }
        return -1;
    }
}