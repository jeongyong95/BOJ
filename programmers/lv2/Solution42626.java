package programmers.lv2;

import java.util.PriorityQueue;

public class Solution42626 {
    // 1. 우선순위 큐(힙)에 원소를 넣는다
    // 2. 앞의 두 개를 꺼내서 섞고 다시 넣는다
    // 3. answer++
    // 4. 모든 스코빌 지수가 k이상인지 평가한다
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 힙은 우선순위 큐로 구현한다
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 기본적으로 낮은 숫자가 우선순위가 높게 배치됨
        // 반대로 하려면 reverseOrder해라
        for (int i : scoville) {
            heap.offer(i);
        }

        while (heap.size() > 1) {
            if (heap.peek() >= K) {
                return answer;
            }

            int first = heap.poll();
            int second = heap.poll();

            int mixer = first + second * 2;
            heap.offer(mixer);
            answer++;
        }
        if (heap.peek() >= K) {
            return answer;
        }
        return -1;
    }
}