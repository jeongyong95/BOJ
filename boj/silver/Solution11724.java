package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
            map[x][y] = 1;
        }
        br.close();

        bw.write(bfs(map) + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(int[][] map) {
        int answer = 0;
        boolean[] visited = new boolean[map.length];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < map.length; i++) {
            if (visited[i]) {
                continue;
            }

            q.offer(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                int current = q.poll();
                for (int j = 1; j < map[current].length; j++) {
                    if (!visited[j] && map[current][j] == 1) {
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
