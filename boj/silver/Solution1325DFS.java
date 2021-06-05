package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution1325DFS {
    static Map<Integer, List<Integer>> adjMap = new HashMap<>();
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();
    static List<Integer> tempList = new ArrayList<>();
    static int n, max = 0, tempMax = 0, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
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

        for (int i = 1; i <= n; i++) {
            dfs(i);
            if (max < tempMax) {
                answer.clear();
                answer.add(i);
                max = tempMax;
            } else if (max == tempMax) {
                answer.add(i);
            }
            tempMax = 0;
            tempList.clear();
        }

        for (int i = 0, size = answer.size(); i < size; i++) {
            bw.write(answer.get(i) + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int start) {
        if (adjMap.get(start).size() == 0) {
            count = tempList.size();
            if (tempMax < count) {
                tempMax = count;
            }
            return;
        }

        List<Integer> current = adjMap.get(start);
        for (Integer i : current) {
            if (!visited[i]) {
                visited[i] = true;
                tempList.add(i);
                dfs(i);
                tempList.remove(i);
                visited[i] = false;
            }
        }
    }
}