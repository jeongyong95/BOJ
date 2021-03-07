package programmers.lv1;

public class Solution12918 {
    public static void main(String[] args) {
        solution("1234");
    }

    public static boolean solution(String s) {
        char[] string = s.toCharArray();
        if (string.length == 4 || string.length == 6) {
            for (int i = 0; i < string.length; i++) {
                if (string[i] < '0' || string[i] > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
