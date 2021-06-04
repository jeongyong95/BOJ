package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*  접미사 배열
    접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.
    baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 
    이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
    문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.
    첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000보다 작거나 같다.
    첫째 줄부터 S의 접미사를 사전순으로 한 줄에 하나씩 출력한다.
 */
public class Solution11656 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> strings = new ArrayList<>();
        String string = bufferedReader.readLine();
        bufferedReader.close();
        int length = string.length();

        for (int i = 0; i < length; i++) {
            strings.add(string);
            string = string.substring(1);
        }

        Collections.sort(strings);
        for (int i = 0; i < strings.size(); i++) {
            bufferedWriter.write(strings.get(i) + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}