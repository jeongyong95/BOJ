package programmers.lv1;

public class Solution12916 {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;

        for (int i = 0, size = s.length(); i < size; i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                count++;
            }
            if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                count--;
            }
        }
        if (count != 0) {
            answer = false;
        }
        return answer;
    }
}
