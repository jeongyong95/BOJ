package programmers.lv1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 6; i >= 0; i--) {
            if (i >= 2) {
                resultMap.put(i, 7 - i);
            } else {
                resultMap.put(i, 6);
            }
        }
        Set<Integer> winNumSet = new HashSet<>();
        for (int i : win_nums) {
            winNumSet.add(i);
        }
        int countZero = 0;
        int countCurrentMatchNumber = 0;
        for (Integer i : lottos) {
            if (i == 0) {
                countZero++;
            } else if (winNumSet.contains(i)) {
                countCurrentMatchNumber++;
            }
        }
        answer[0] = resultMap.get(countCurrentMatchNumber + countZero);
        answer[1] = resultMap.get(countCurrentMatchNumber);
        return answer;
    }
}