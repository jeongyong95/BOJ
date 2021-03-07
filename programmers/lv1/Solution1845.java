package programmers.lv1;

import java.util.HashSet;
import java.util.Set;

public class Solution1845 {
    public int solution(int[] nums) {
        int answer = 0;
        int limit = nums.length / 2;
        Set<Integer> pocket = new HashSet<>();
        for (int i : nums) {
            pocket.add(i);
        }

        if (pocket.size() > limit) {
            answer = limit;
        } else {
            answer = pocket.size();
        }
        return answer;
    }
}
