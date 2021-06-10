package programmers.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution43164 {
    static Map<String, List<Ticket>> ticketMap = new HashMap<>();
    static String[] answer;
    static boolean isSolved = false;

    public static void main(String[] args) {
        String[][] tickets = { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" }, { "BOO", "DOO" } };
        solution(tickets);
    }

    public static String[] solution(String[][] tickets) {

        for (String[] s : tickets) {
            List<Ticket> nextList = ticketMap.getOrDefault(s[0], new ArrayList<>());
            nextList.add(new Ticket(s[1], false));
            ticketMap.put(s[0], nextList);
        }

        for (String key : ticketMap.keySet()) {
            List<Ticket> nextList = ticketMap.get(key);
            Collections.sort(nextList);
        }
        answer = new String[tickets.length + 1];
        answer[0] = "ICN";
        dfs(answer[0], 1);
        return answer;
    }

    static void dfs(String current, int index) {
        if (index == answer.length) {
            isSolved = true;
            return;
        }

        List<Ticket> nextList = ticketMap.get(current);
        if (nextList == null) {
            return;
        }

        for (Ticket ticket : nextList) {
            if (!ticket.isUsed) {
                ticket.isUsed = true;
                answer[index] = ticket.next;
                dfs(ticket.next, index + 1);
                if (isSolved) {
                    return;
                }
                ticket.isUsed = false;
            }
        }
    }
}

class Ticket implements Comparable<Ticket> {
    String next;
    boolean isUsed;

    public Ticket(String next, boolean isUsed) {
        this.next = next;
        this.isUsed = isUsed;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.next.compareTo(o.next);
    }
}