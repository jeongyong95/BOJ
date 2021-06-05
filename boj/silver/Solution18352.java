package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution18352 {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int n, m, k, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
        }
        br.close();

        List<Integer> answer = bfs();
        if (answer.size() == 0) {
            bw.write(-1 + "\n");
        } else {
            Collections.sort(answer);
            for (Integer i : answer) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static List<Integer> bfs() {
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(x);
        visited[x] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            List<Integer> adjList = map.get(current);
            for (Integer i : adjList) {
                if (!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    distance[i] = distance[current] + 1;
                    if (distance[i] == k) {
                        answer.add(i);
                    }
                }
            }
        }
        return answer;
    }
}
