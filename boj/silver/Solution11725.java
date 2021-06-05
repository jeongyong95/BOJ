package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution11725 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            map.get(parent).add(child);
            map.get(child).add(parent);
        }

        int[] result = bfs(map);
        for (int i = 2; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int[] bfs(Map<Integer, List<Integer>> map) {
        int[] answer = new int[map.size() + 1];
        boolean[] visited = new boolean[map.size() + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 0; i < map.get(current).size(); i++) {
                int target = map.get(current).get(i);
                if (!visited[target]) {
                    q.offer(target);
                    answer[target] = current;
                    visited[target] = true;
                }
            }
        }
        return answer;
    }
}
