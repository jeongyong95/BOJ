package boj.graphSearch.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2206 {
    static int[][] map;
    static int[][][] dist;
    static int[] moveN = { 0, 0, -1, 1 };
    static int[] moveM = { -1, 1, 0, 0 };
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();

        int answer = bfs();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        int answer = -1;
        int[] start = { 0, 0, 0 };

        dist[0][0][0] = 1;
        q.offer(start);
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];
            int blockingFlag = current[2];
            if (y == map.length - 1 && x == map[y].length - 1) {
                return dist[y][x][blockingFlag];
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + moveN[i];
                int nextX = x + moveM[i];

                if (nextY >= 0 && nextY < map.length && nextX >= 0 && nextX < map[nextY].length) {
                    if (dist[nextY][nextX][blockingFlag] == 0) {
                        if (map[nextY][nextX] == 1 && blockingFlag == 0) {
                            dist[nextY][nextX][1] = dist[y][x][blockingFlag] + 1;
                            int[] next = { nextY, nextX, 1 };
                            q.offer(next);
                        } else if (map[nextY][nextX] == 0) {
                            dist[nextY][nextX][blockingFlag] = dist[y][x][blockingFlag] + 1;
                            int[] next = { nextY, nextX, blockingFlag };
                            q.offer(next);
                        }
                    }
                }
            }
        }
        return answer;
    }
}