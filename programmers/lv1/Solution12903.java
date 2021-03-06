package programmers.lv1;

public class Solution12903 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        if (len % 2 == 0) {
            sb.append(s, len / 2 - 1, len / 2 + 1);
        } else {
            sb.append(s.charAt(len / 2));
        }
        return sb.toString();
    }
}
