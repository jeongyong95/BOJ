package programmers.lv1;

import java.util.Arrays;

public class Solution12919 {
    public String solution(String[] seoul) {
        String target = "Kim";
        int index = Arrays.asList(seoul).indexOf(target);
        return "김서방은 " + index + "에 있다";
    }
}
