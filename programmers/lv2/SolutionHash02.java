package programmers.lv2;

import java.util.Arrays;

public class SolutionHash02 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].indexOf(phone_book[i - 1], 0) == 0) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
