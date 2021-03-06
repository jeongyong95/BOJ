package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class Solution42576Re {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> ptcMap = new HashMap<>();

        for (String string : participant) {
            ptcMap.put(string, ptcMap.getOrDefault(string, 0) + 1);
        }

        for (String string : completion) {
            ptcMap.put(string, ptcMap.get(string) - 1);
        }

        for (String string : ptcMap.keySet()) {
            if (ptcMap.get(string) != 0) {
                answer = string;
                break;
            }
        }
        return answer;
    }
}