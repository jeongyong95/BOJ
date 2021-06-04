package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3187 {
    static char[][] map;
    static boolean[][] visited;
    static int[] moveR = { 0, 0, -1, 1 };
    static int[] moveC = { -1, 1, 0, 0 };
    static int v = 0, k = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();

        int[] answer = new int[2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    if (map[i][j] == 'v') {
                        v++;
                    } else if (map[i][j] == 'k') {
                        k++;
                    }

                    visited[i][j] = true;
                    int[] start = { i, j };
                    dfs(start);

                    if (v < k) {
                        answer[0] += k;
                    } else {
                        answer[1] += v;
                    }
                    v = 0;
                    k = 0;
                }
            }
        }
        bw.write(answer[0] + " " + answer[1] + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int[] current) {
        for (int i = 0; i < 4; i++) {
            int[] temp = { current[0] + moveR[i], current[1] + moveC[i] };
            if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[temp[0]].length) {
                if (map[temp[0]][temp[1]] != '#' && !visited[temp[0]][temp[1]]) {
                    if (map[temp[0]][temp[1]] == 'v') {
                        v++;
                    } else if (map[temp[0]][temp[1]] == 'k') {
                        k++;
                    }
                    visited[temp[0]][temp[1]] = true;
                    dfs(temp);
                }
            }
        }
    }
}