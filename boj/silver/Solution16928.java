package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution16928 {
    static int[] dist = new int[101];
    static boolean[] visited = new boolean[101];
    static Queue<Integer> q = new LinkedList<>();
    static Map<Integer, Integer> laddersAndSnakes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            laddersAndSnakes.put(current, next);
        }
        br.close();

        int answer = bfs();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        visited[1] = true;
        q.offer(1);
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if (laddersAndSnakes.containsKey(next)) {
                    int goNext = laddersAndSnakes.get(next);
                    if (!visited[goNext]) {
                        dist[goNext] = dist[current] + 1;
                        visited[goNext] = true;
                        q.offer(goNext);
                    }
                } else if (next <= 100 && !visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[current] + 1;
                    q.offer(next);
                }
            }
            if (visited[100]) {
                return dist[100];
            }
        }
        return -1;
    }
}