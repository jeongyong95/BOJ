package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  문자열 분석
    문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
    각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.
    첫째 줄부터 N번째 줄까지 문자열이 주어진다. (1 ≤ N ≤ 100) 문자열의 길이는 100을 넘지 않는다.
    첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.
 */
public class Solution10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = bufferedReader.readLine()).equals("")) {
            if ((input = bufferedReader.readLine()).equals("")) {
                break;
            }
            bufferedWriter.write(checkChar(input) + "\n");
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static String checkChar(String string) {
        int lowerC = 0;
        int upperC = 0;
        int number = 0;
        int space = 0;

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                upperC++;
            }
            if (character >= 'a' && character <= 'z') {
                lowerC++;
            }
            if (character >= '0' && character <= '9') {
                number++;
            }
            if (character == ' ') {
                space++;
            }
        }

        return lowerC + " " + upperC + " " + number + " " + space;
    }
}