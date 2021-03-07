package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution12935 {
    public int[] solution(int[] arr) {
        int[] answer = new int[1];
        answer[0] = -1;

        if (arr.length > 1) {
            int min = Arrays.stream(arr).min().getAsInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > min) {
                    list.add(arr[i]);
                }
            }

            answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
        }

        return answer;
    }
}
