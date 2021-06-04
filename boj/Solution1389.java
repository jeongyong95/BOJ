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

public class Solution1389 {
    public static void main(String[] args) throws NumberFormatException, IOException {
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

        bw.write(bfs(map) + "\n");
        bw.flush();
        bw.close();

    }

    static int bfs(Map<Integer, List<Integer>> map) {
        int size = map.size() + 1;
        int[] answerSheet = { size, 10000 };
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < size; i++) {
            int[] distance = new int[size];
            boolean[] visited = new boolean[size];

            q.offer(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                int current = q.poll();
                List<Integer> list = map.get(current);
                for (int j = 0, listSize = list.size(); j < listSize; j++) {
                    int target = list.get(j);
                    if (!visited[target]) {
                        q.offer(target);
                        distance[target] = distance[current] + 1;
                        visited[target] = true;
                    }
                }
            }
            int sum = Arrays.stream(distance).sum();
            if (answerSheet[1] > sum) {
                answerSheet[0] = i;
                answerSheet[1] = sum;
            } else if (answerSheet[1] == sum) {
                continue;
            }
        }
        return answerSheet[0];
    }
}
