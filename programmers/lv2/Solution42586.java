package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution42586 {
    public static void main(String[] args) {
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };
        solution(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        int progress = 0;

        for (int i = 0; i < progresses.length; i++) {
            q.offer(i);
        }

        while (progress < progresses.length) {
            for (int i = progress; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            while (progress < progresses.length && progresses[progress] >= 100) {
                q.poll();
                count++;
                progress++;
            }
            if (count > 0) {
                answerList.add(count);
            }
            count = 0;
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
