package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] strings : clothes) {
            map.put(strings[1], map.getOrDefault(strings[1], 0) + 1);
        }
        for (String strings : map.keySet()) {
            answer *= map.get(strings) + 1;
        }
        answer--;
        return answer;
    }
}
