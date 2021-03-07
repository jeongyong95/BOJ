package programmers.lv1;

public class Solution12948 {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder(phone_number);
        int len = sb.length() - 4;
        for (int i = 0; i < len; i++) {
            sb.replace(i, i + 1, "*");
        }
        return sb.toString();
    }
}
