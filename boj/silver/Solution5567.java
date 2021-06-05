package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5567 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }
        br.close();

        bw.write(bfs(map) + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(int[][] map) {
        int answer = 0;
        boolean[] visited = new boolean[map.length];
        int[] distance = new int[map.length];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 1; i < map[current].length; i++) {
                if (!visited[i] && map[current][i] == 1) {
                    q.offer(i);
                    distance[i] = distance[current] + 1;
                    visited[i] = true;
                    if (distance[i] > 2) {
                        return answer;
                    }
                    if (distance[i] > 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
