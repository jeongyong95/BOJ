package programmers.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution64064 {
    static String[] users;
    static String[] bannedUsers;
    static boolean[] visited;
    static List<String> candidates = new ArrayList<>();
    static Set<String> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        bannedUsers = banned_id;
        visited = new boolean[users.length];

        for (int i = 0; i < banned_id.length; i++) {
            // banned_id[i] = banned_id[i].replaceAll("\\*", ".");
            banned_id[i] = banned_id[i].replaceAll("[*]", "\\.");
        }

        dfs(0);
        int answer = resultSet.size();
        return answer;
    }

    static void dfs(int index) {
        if (index == bannedUsers.length) {
            StringBuilder sb = new StringBuilder();
            Collections.sort(candidates);
            for (int i = 0, size = candidates.size(); i < size; i++) {
                sb.append(candidates.get(i));
            }
            resultSet.add(sb.toString());
            return;
        }
        for (int i = 0; i < users.length; i++) {
            if (!visited[i] && users[i].matches(bannedUsers[index])) {
                visited[i] = true;
                candidates.add(users[i]);
                dfs(index + 1);
                candidates.remove(users[i]);
                visited[i] = false;
            }
        }
    }
}
