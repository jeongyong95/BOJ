package programmers.lv1;

import java.util.Set;
import java.util.TreeSet;

public class Solution68644 {
    public int[] solution(int[] numbers) {
        Set<Integer> answerSet = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answerSet.add(numbers[i] + numbers[j]);
            }
        }
        int i = 0;
        int[] answer = new int[answerSet.size()];
        for (int result : answerSet) {
            answer[i++] = result;
        }
        return answer;
    }
}