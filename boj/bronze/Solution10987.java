package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  모음의 개수
    알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 모음(a, e, i, o, u)의 개수를 출력하는 프로그램을 작성하시오.
    첫째 줄에 단어가 주어진다. 단어의 길이는 1보다 크거나 같고, 100보다 작거나 같으며, 알파벳 소문자로만 이루어져 있다.
    첫째 줄에 모음의 개수를 출력한다.
 */
public class Solution10987 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = bufferedReader.readLine();
        bufferedReader.close();

        char[] vowelArray = { 'a', 'e', 'i', 'o', 'u' };
        int counter = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < vowelArray.length; j++) {
                if (word.charAt(i) == vowelArray[j]) {
                    counter++;
                }
            }
        }

        bufferedWriter.write(counter + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}