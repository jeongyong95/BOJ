package programmers.lv3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution43162 {
    static int[][] map;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();

    static int[] link;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        // map = computers;
        // visited = new boolean[n];

        // for (int i = 0; i < computers.length; i++) {
        // if (!visited[i]) {
        // bfs(i);
        // answer++;
        // }
        // }

        link = new int[n];
        for (int i = 0; i < link.length; i++) {
            link[i] = i;
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1 && !isSame(i, j)) {
                    unite(i, j);
                }
            }
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < computers.length; i++) {
            resultSet.add(find(i));
        }
        answer = resultSet.size();
        return answer;
    }

    static int find(int x) {
        if (x == link[x]) {
            return x;
        }
        return link[x] = find(link[x]);
    }

    static void unite(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            link[Math.max(a, b)] = Math.min(a, b);
        }
    }

    static boolean isSame(int a, int b) {
        return find(a) == find(b);
    }

    // 너비우선탐색
    static void bfs(int start) {
        visited[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 0; i < map[current].length; i++) {
                if (i != current && map[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
