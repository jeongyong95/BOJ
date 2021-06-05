package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2468 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int low = 100;
        int high = 1;

        int[][] map = new int[n][n];
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (high < map[i][j]) {
                    high = map[i][j];
                }
                if (low > map[i][j]) {
                    low = map[i][j];
                }
            }
        }
        br.close();

        bw.write(bfs(map, low, high) + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(int[][] map, int low, int high) {
        int answer = 1;
        int[] moveW = { 0, 0, -1, 1 };
        int[] moveH = { -1, 1, 0, 0 };
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> q = new LinkedList<>();

        for (int i = low; i < high; i++) {
            int result = 0;

            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map[j].length; k++) {
                    if (!visited[j][k] && map[j][k] > i) {
                        int[] start = { j, k };
                        q.offer(start);
                        visited[j][k] = true;

                        while (!q.isEmpty()) {
                            int[] current = q.poll();
                            for (int l = 0; l < 4; l++) {
                                int[] temp = { current[0] + moveH[l], current[1] + moveW[l] };
                                if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[j].length) {
                                    if (!visited[temp[0]][temp[1]] && map[temp[0]][temp[1]] > i) {
                                        q.offer(temp);
                                        visited[temp[0]][temp[1]] = true;
                                    }
                                }
                            }
                        }
                        result++;
                    }
                }
            }
            if (answer < result) {
                answer = result;
            }

            for (int j = 0; j < visited.length; j++) {
                for (int k = 0; k < visited[j].length; k++) {
                    if (visited[j][k]) {
                        visited[j][k] = false;
                    }
                }
            }
        }
        return answer;
    }
}
