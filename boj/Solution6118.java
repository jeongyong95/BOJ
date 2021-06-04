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

public class Solution6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        br.close();

        int[] answer = bfs(map);
        for (int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();

    }

    static int[] bfs(Map<Integer, List<Integer>> map) {
        int[] answer = new int[3];
        boolean[] visited = new boolean[map.size() + 1];
        int[] distance = new int[visited.length];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            List<Integer> currentList = map.get(current);
            for (int i = 0, size = currentList.size(); i < size; i++) {
                int target = currentList.get(i);
                if (!visited[target]) {
                    q.offer(target);
                    visited[target] = true;
                    distance[target] = distance[current] + 1;
                }
            }
        }
        int max = Arrays.stream(distance).max().getAsInt();
        answer[1] = max;
        answer[0] = visited.length;

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == max) {
                answer[2]++;
                if (answer[0] > i) {
                    answer[0] = i;
                }
            }
        }
        return answer;
    }
}