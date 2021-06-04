package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  알파벳 개수
    알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
    첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
    단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.
 */
public class Solution10808 {
    // 아스키 코드가 필요하면 charArray를 사용해라
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphabet = new int[26];
        char[] word = bufferedReader.readLine().toCharArray();
        bufferedReader.close();

        for (char c : word) {
            alphabet[c - 97]++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            bufferedWriter.write(alphabet[i] + " ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}