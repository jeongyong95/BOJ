package programmers.lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution42627 {
    // 1. 우선순위 큐로 힙을 구현한다.
    // 2. 현재 시간에 시작할 수 있는 작업 중 버스트 타임이 작은 것을 먼저 처리한다.
    // 3. 작업이 완료되면 answer에 더한다.
    // 4. 현재 시간에 작업시간을 그만큼 더한다.

    public static void main(String[] args) {
        int[][] jobs = { { 1, 9 }, { 2, 6 }, { 0, 3 } };
        solution(jobs);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int start = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (start < jobs.length) {
            for (int i = start; i < jobs.length; i++) {
                if (jobs[start][0] <= time) {
                    heap.offer(jobs[start++]);
                } else {
                    break;
                }
            }

            if (!heap.isEmpty()) {
                int[] temp = heap.poll();
                answer += temp[1] + time - temp[0];
                time += temp[1];
            } else {
                time = jobs[start][0];
            }
        }
        return (int) Math.floor(answer / jobs.length);
    }
}