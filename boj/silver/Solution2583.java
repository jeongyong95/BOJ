package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[m][n];

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = y; i < y2; i++) {
                for (int j = x; j < x2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        br.close();
        List<Integer> answer = bfs(map);
        Collections.sort(answer);

        bw.write(answer.size() + "\n");
        for (int i : answer) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }

    static List<Integer> bfs(int[][] map) {
        List<Integer> answer = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        int[] moveN = { 0, 0, -1, 1 };
        int[] moveM = { -1, 1, 0, 0 };

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    continue;
                }

                int[] start = { i, j };
                int sectionSize = 1;
                q.offer(start);
                map[i][j] = 1;

                while (!q.isEmpty()) {
                    int[] current = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int[] temp = { current[0] + moveN[k], current[1] + moveM[k] };
                        if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[temp[0]].length) {
                            if (map[temp[0]][temp[1]] == 0) {
                                sectionSize++;
                                q.offer(temp);
                                map[temp[0]][temp[1]] = 1;
                            }
                        }
                    }
                }
                answer.add(sectionSize);
            }
        }
        return answer;
    }
}