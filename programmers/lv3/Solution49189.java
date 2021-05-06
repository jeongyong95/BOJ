package programmers.lv3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution49189 {
    static int[] dist;
    static boolean[] visited;
    static List<Integer>[] adj;
    static Queue<Integer> q = new LinkedList<>();

    public int solution(int n, int[][] edge) {
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int answer = bfs();
        return answer;
    }

    static int bfs() {
        int answer = 0;
        int max = 0;

        visited[1] = true;
        q.offer(1);
        while (!q.isEmpty()) {
            int current = q.poll();
            for (Integer i : adj[current]) {
                if (!visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[current] + 1;
                    if (max < dist[i]) {
                        max = dist[i];
                    }
                    q.offer(i);
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == max) {
                answer++;
            }
        }
        return answer;
    }
}