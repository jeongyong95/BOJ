package programmers.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO : 프로그래머스 킷 그래프 탐색 틀림;;;;
public class Solution46164 {
    static boolean isFind = false;
    static String[] answer;
    static Map<String, Boolean> visited = new HashMap<>();
    static Map<String, List<String>> ticketMap = new HashMap<>();

    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            List<String> destList = ticketMap.getOrDefault(tickets[i][0], new ArrayList<>());
            destList.add(tickets[i][1]);
            ticketMap.put(tickets[i][0], destList);
            visited.put(tickets[i][0], false);
        }

        answer = new String[ticketMap.size()];
        for (List<String> dest : ticketMap.values()) {
            Collections.sort(dest);
        }
        for (String start : ticketMap.keySet()) {
            if (isFind) {
                break;
            }
            answer[0] = start;
            dfs(1, start);
        }

        return answer;
    }

    static void dfs(int index, String start) {
        if (index == ticketMap.size()) {
            isFind = true;
            return;
        }

        for (String dest : ticketMap.get(start)) {
            if (!visited.get(dest)) {
                visited.put(dest, true);
                answer[index] = dest;
                dfs(index + 1, dest);
                if (isFind) {
                    return;
                }
                visited.put(dest, false);
            }
        }
    }
}
