package programmers.lv3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution42628 {
    // 1. 우선순위 큐를 2개 만든다.
    // 2. 하나는 작은 값 우선, 다른 하나는 큰 값 우선
    // 3. 값이 추가되면 양쪽에 모두 더한다.
    // 4. 빈 큐에 삭제 연산은 무시한다.
    // 5. 삭제 연산은 각자 한다.
    // 6. 비어있으면 0,0 그러지 않으면 최댓값 최솟값 출력
    public int[] solution(String[] operations) {
        int[] answer = { 0, 0 };

        PriorityQueue<Integer> ascQ = new PriorityQueue<>();
        PriorityQueue<Integer> descQ = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });

        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");

            if (operation[0].equals("I")) {
                int number = Integer.parseInt(operation[1]);
                ascQ.offer(number);
                descQ.offer(number);
            }
            if (operations[i].equals("D 1")) {
                ascQ.remove(descQ.poll());
            }
            if (operations[i].equals("D -1") && !ascQ.isEmpty()) {
                descQ.remove(ascQ.poll());
            }
        }
        if (ascQ.size() > 0) {
            answer[0] = descQ.peek();
            answer[1] = ascQ.peek();
        }
        return answer;
    }
}
