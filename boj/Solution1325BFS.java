package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1325BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            List<Integer> adjList = adjMap.get(b);
            adjList.add(a);
        }
        br.close();

        List<Integer> answer = bfs(adjMap);
        for (Integer i : answer) {
            bw.write(i + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    static List<Integer> bfs(Map<Integer, List<Integer>> adjMap) {
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[adjMap.size() + 1];
        Queue<Integer> q = new LinkedList<>();
        int max = 0;

        for (int i = 1, size = adjMap.size() + 1; i < size; i++) {
            int tempMax = 0;
            q.offer(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                int current = q.poll();
                List<Integer> currentList = adjMap.get(current);

                for (int j = 0, currentSize = currentList.size(); j < currentSize; j++) {
                    int target = currentList.get(j);
                    if (!visited[target]) {
                        q.offer(target);
                        visited[target] = true;
                    }
                }
            }

            for (int j = 0; j < visited.length; j++) {
                if (visited[j]) {
                    tempMax++;
                }
            }

            if (max < tempMax) {
                answer.clear();
                answer.add(i);
                max = tempMax;
            } else if (max == tempMax) {
                answer.add(i);
            }
            Arrays.fill(visited, false);
        }
        return answer;
    }
}