package programmers.lv3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution43163 {
    static Queue<String> q = new LinkedList<>();
    static Map<String, Boolean> visited = new HashMap<>();
    static Map<String, Integer> dist = new HashMap<>();

    public int solution(String begin, String target, String[] words) {
        int answer = bfs(begin, target, words);
        return answer;
    }

    static int bfs(String begin, String target, String[] words) {
        q.offer(begin);
        visited.put(begin, true);
        dist.put(begin, 0);

        while (!q.isEmpty()) {
            String current = q.poll();

            for (String s : words) {
                if (isPossibleNext(current, s)) {
                    if (!visited.getOrDefault(s, false)) {
                        if (s.equals(target)) {
                            return dist.get(current) + 1;
                        }
                        visited.put(s, true);
                        dist.put(s, dist.get(current) + 1);
                        q.offer(s);
                    }
                }
            }
        }
        return 0;
    }

    static boolean isPossibleNext(String current, String target) {
        int diff = 0;
        for (int i = 0, size = current.length(); i < size; i++) {
            if (current.charAt(i) != target.charAt(i)) {
                diff++;
            }
        }
        if (diff > 1) {
            return false;
        }
        return true;
    }
}