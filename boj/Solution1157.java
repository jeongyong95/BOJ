package boj;

import java.util.Scanner;

/*  단어 공부
    알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
    단, 대문자와 소문자를 구분하지 않는다.
    첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다.
    주어지는 단어의 길이는 1,000,000을 넘지 않는다.
    첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
    단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */
public class Solution1157 {
    // 2시간 이상, 복습 0회
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        scanner.close();

        char[] charWord = word.toCharArray();
        int[] checkArray = new int[26];
        int maxIndex = 0;
        Boolean questionFlag = false;

        // 소문자 - 문자별 사용횟수 카운트
        for (char c : charWord) {
            for (char i = 'A'; i <= 'Z'; i++) {
                if (c == i) {
                    checkArray[c - 65] += 1;
                }
            }
            for (char i = 'a'; i <= 'z'; i++) {
                if (c == i) {
                    checkArray[c - 97] += 1;
                }
            }
        }

        // 가장 많이 사용한 문자 출력
        for (int i = 0; i < 26; i++) {
            if (checkArray[maxIndex] < checkArray[i]) {
                maxIndex = i;
                questionFlag = false;
            }
            if (maxIndex != i && checkArray[maxIndex] == checkArray[i]) {
                questionFlag = true;
            }
        }
        if (!questionFlag) {
            System.out.println((char) (maxIndex + 65));
        }
        if (questionFlag) {
            System.out.println("?");
        }
    }
}