package programmers.lv1;

import java.util.Arrays;

public class Solution12917 {
    public String solution(String s) {
        char[] string = s.toCharArray();
        Arrays.sort(string);

        return new StringBuilder(new String(string)).reverse().toString();
    }
}
