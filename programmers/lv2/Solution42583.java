package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int current = 0;
        for (int truck : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.offer(truck);
                    current += truck;
                    answer++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    current -= bridge.poll();
                } else if (current + truck > weight) {
                    bridge.offer(0);
                    answer++;
                } else {
                    bridge.offer(truck);
                    current += truck;
                    answer++;
                    break;
                }
            }
        }
        return answer + bridge_length;
    }
}
