package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution16948 {
    static int[][] map;
    static boolean[][] visited;
    static int[] start = new int[2];
    static int[] end = new int[2];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());
        br.close();

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        int answer = -1;
        int[] moveR = { -2, -2, 0, 0, 2, 2 };
        int[] moveC = { -1, 1, -2, 2, -1, 1 };
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < 6; i++) {
                int[] temp = { current[0] + moveR[i], current[1] + moveC[i] };
                if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[temp[0]].length) {
                    if (!visited[temp[0]][temp[1]]) {
                        q.offer(temp);
                        visited[temp[0]][temp[1]] = true;
                        map[temp[0]][temp[1]] = map[current[0]][current[1]] + 1;
                        if (temp[0] == end[0] && temp[1] == end[1]) {
                            answer = map[end[0]][end[1]];
                            return answer;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
