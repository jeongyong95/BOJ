package programmers.lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution42627 {
    // 1. 요청시간<=현재시간인 작업을 모두 큐에 추가한다.
    // 2. 큐에 있는 작업을 한 번 한다. 왜냐하면 매번 비교해야하기 때문이다.
    // 3. time과 결과 배열에 담을 총 작업시간을 구분해서 기록한다.
    // 4. 큐가 비어있다면, 현재 작업하는 게 없으므로 가장 가까운 작업을 수행한다.
    public static void main(String[] args) {
        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
        int result = solution(jobs);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int current = 0;
        int complete = 0;
        int count = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        while (count < jobs.length) {
            while (complete < jobs.length && jobs[complete][0] <= current) {
                q.offer(jobs[complete++]);
            }

            if (q.isEmpty()) {
                current = jobs[complete][0];
            } else {
                int[] finishedJob = q.poll();
                count++;
                current += finishedJob[1];
                answer += current - finishedJob[0];
            }
        }
        return answer / jobs.length;
    }
}