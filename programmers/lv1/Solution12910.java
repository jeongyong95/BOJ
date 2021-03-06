package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution12910 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answerList.add(arr[i]);
            }
        }
        answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        if (answerList.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        Arrays.sort(answer);
        return answer;
    }
}
