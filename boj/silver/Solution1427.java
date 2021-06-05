package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*  소트인사이드
    배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
    첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
    첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */
public class Solution1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] number = bufferedReader.readLine().toCharArray();
        bufferedReader.close();

        Arrays.sort(number);

        for (int i = number.length - 1; i > -1; i--) {
            bufferedWriter.write(number[i]);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}