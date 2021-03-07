package programmers.lv1;

import java.util.Arrays;

public class Solution12944 {
    public double solution(int[] arr) {
        double answer = Arrays.stream(arr).average().getAsDouble();
        return answer;
    }
}
