package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class Solution42840 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] student1 = { 1, 2, 3, 4, 5 };
        int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int[] count = new int[4];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % 5]) {
                count[1]++;
            }
            if (answers[i] == student2[i % 8]) {
                count[2]++;
            }
            if (answers[i] == student3[i % 10]) {
                count[3]++;
            }
        }
        int max = count[1];
        for (int i = 2; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        List<Integer> answerList = new ArrayList<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i] == max) {
                answerList.add(i);
            }
        }
        answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
