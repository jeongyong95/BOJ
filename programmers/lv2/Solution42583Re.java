package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution42583Re {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int current = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            while (true) {
                if (q.isEmpty()) {
                    q.add(truck_weights[i]);
                    current += truck_weights[i];
                    answer++;
                    break;
                } else if (q.size() == bridge_length) {
                    current -= q.poll();
                } else if (current + truck_weights[i] > weight) {
                    q.add(0);
                    answer++;
                } else {
                    q.add(truck_weights[i]);
                    current += truck_weights[i];
                    answer++;
                    break;
                }
            }
        }

        return answer + bridge_length;
    }
}