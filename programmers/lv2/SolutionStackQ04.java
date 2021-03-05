package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionStackQ04 {
    // 1.큐를 만든다
    // 2. 우선순위를 다 넣는다
    // 3. 안에 하나라도 있으면 뒤로 보낸다. 이때 로케이션도 위치 변경
    // 4. 출력이 될 때마다 출력 카운트와 로케이션 카운트를 조정한다. 배열도 0
    public int solution(int[] priorities, int location) {
        int count = 0;
        Queue<Integer> printer = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            printer.offer(priorities[i]);
        }
        Arrays.sort(priorities);

        while (count++ < priorities.length) {
            int max = priorities[priorities.length - count];
            int target = printer.peek();
            if (target < max) {
                printer.offer(printer.remove());
                if (location == 0) {
                    location = printer.size();
                }
                break;
            } else {
                if (location == 0) {
                    return count;
                }
                printer.poll();
                priorities[priorities.length - count] = 0;
                location--;
            }
        }
        return count;
    }
}
