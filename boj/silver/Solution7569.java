package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7569 {
    static Queue<int[]> q = new LinkedList<>();
    static int remain = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] map = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        int[] start = { i, j, k };
                        q.offer(start);
                    } else if (map[i][j][k] == 0) {
                        remain++;
                    }
                }
            }
        }
        br.close();

        bw.write(bfs(map) + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(int[][][] map) {
        int answer = 0;
        int cycle = q.size();
        int[] moveH = { 0, 0, 0, 0, -1, 1 };
        int[] moveN = { 0, 0, -1, 1, 0, 0 };
        int[] moveM = { -1, 1, 0, 0, 0, 0 };

        while (!q.isEmpty()) {
            if (cycle == 0) {
                cycle = q.size();
                answer++;
            }

            int[] current = q.poll();
            cycle--;
            for (int i = 0; i < 6; i++) {
                int[] temp = { current[0] + moveH[i], current[1] + moveN[i], current[2] + moveM[i] };
                if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[temp[0]].length
                        && temp[2] >= 0 && temp[2] < map[temp[0]][temp[1]].length) {
                    if (map[temp[0]][temp[1]][temp[2]] == 0) {
                        q.offer(temp);
                        map[temp[0]][temp[1]][temp[2]] = 1;
                        remain--;
                    }
                }
            }
        }

        if (remain > 0) {
            return -1;
        }
        return answer;
    }
}
