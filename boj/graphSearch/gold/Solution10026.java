package boj.graphSearch.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution10026 {
    static int[] moveN = { 0, 0, -1, 1 };
    static int[] moveM = { -1, 1, 0, 0 };
    static Queue<Position> q = new LinkedList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        char[][] colorWeakMap = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        boolean[][] visitedWeak = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'G') {
                    colorWeakMap[i][j] = 'R';
                } else {
                    colorWeakMap[i][j] = map[i][j];
                }
            }
        }
        br.close();

        int[] answer = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    q.offer(new Position(i, j));
                    bfs(map, visited);
                    answer[0]++;
                }
                if (!visitedWeak[i][j]) {
                    visitedWeak[i][j] = true;
                    q.offer(new Position(i, j));
                    bfs(colorWeakMap, visitedWeak);
                    answer[1]++;
                }
            }
        }

        bw.write(answer[0] + " " + answer[1] + "\n");
        bw.flush();
        bw.close();
    }

    static void bfs(char[][] map, boolean[][] visited) {
        while (!q.isEmpty()) {
            Position current = q.poll();
            char color = map[current.n][current.m];

            for (int i = 0; i < 4; i++) {
                Position next = new Position(current.n + moveN[i], current.m + moveM[i]);
                if (next.n >= 0 && next.n < map.length && next.m >= 0 && next.m < map[next.n].length) {
                    if (map[next.n][next.m] == color && !visited[next.n][next.m]) {
                        visited[next.n][next.m] = true;
                        q.offer(next);
                    }
                }
            }
        }
    }
}

class Position {
    int n;
    int m;

    public Position() {
    }

    public Position(int n, int m) {
        this.n = n;
        this.m = m;
    }
}