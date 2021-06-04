package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1012 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] answerArr = new int[t];

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }
            answerArr[i] = bfs(map);
        }
        br.close();

        for (int i : answerArr) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int bfs(int[][] map) {
        int answer = 0;
        int[] moveN = { 0, 0, -1, 1 };
        int[] moveM = { -1, 1, 0, 0 };

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                int[] start = { i, j };
                q.offer(start);
                map[i][j] = 0;

                while (!q.isEmpty()) {
                    int[] current = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int[] temp = { current[0] + moveN[k], current[1] + moveM[k] };
                        if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[temp[0]].length) {
                            if (map[temp[0]][temp[1]] == 1) {
                                q.offer(temp);
                                map[temp[0]][temp[1]] = 0;
                            }
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}
