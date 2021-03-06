package programmers.lv1;

import java.util.HashSet;
import java.util.Set;

public class Solution72410 {
    // 틀렸당
    public String solution(String new_id) {
        String answer = "";
        Set<Character> possibleCharSet = new HashSet<>();

        for (char i = 'a'; i <= 'z'; i++) {
            possibleCharSet.add(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            possibleCharSet.add(i);
        }
        possibleCharSet.add('-');
        possibleCharSet.add('_');
        possibleCharSet.add('.');

        answer = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder(answer);
        int i = 0;
        while (i < sb.length()) {
            if (!possibleCharSet.contains(sb.charAt(i))) {
                sb.deleteCharAt(i);
            } else {
                i++;
            }

        }
        i = 0;
        int count = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == '.') {
                count++;
                if (count > 1) {
                    sb.deleteCharAt(i);
                }
            } else {
                count = 0;
                i++;
            }
        }
        if (sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.toString().isBlank()) {
            sb.append("a");
        }

        if (sb.length() > 15) {
            sb.delete(15, sb.length() - 1);
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (sb.length() < 3) {
            char last = sb.charAt(sb.length() - 1);
            while (sb.length() < 3) {
                sb.append(last);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
