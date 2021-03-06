package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution42587 {
    // 1. 큐를 만들어서 우선순위를 다 넣는다
    // 2. 큐의 앞에 있는 문서를 peek한다. 이때 peek한 게 타겟인지 확인
    // 3. 우선순위 배열을 모두 검사해서 중요도가 높은 게 있는지 확인한다.
    // 4. 하나라도 있으면 peek한 것을 큐의 맨 뒤로 보낸다.
    // 5. 없으면 큐에서 제거하고 answer++한다. 타겟의 위치를 수정한다.
    public static void main(String[] args) {
        int[] priorities = { 2, 1, 3, 2 };
        int location = 2;
        solution(priorities, location);
    }

    public static int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        for (int i : priorities) {
            q.offer(i);
        }
        Arrays.sort(priorities);
        int i = priorities.length - 1;

        int answer = 0;
        while (i >= 0) {
            int target = q.peek();

            if (target < priorities[i]) {
                q.offer(q.poll());
                if (location == 0) {
                    location = q.size();
                }
                location--;
            } else {
                if (location == 0) {
                    return answer + 1;
                }
                q.poll();
                priorities[i--] = 0;
                location--;
                answer++;
            }
        }
        return answer + 1;
    }
}
