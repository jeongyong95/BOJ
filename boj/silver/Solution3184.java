package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution3184 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];

        for (int i = 0; i < map.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        br.close();

        int[] answer = bfs(map);
        bw.write(answer[0] + " " + answer[1] + "\n");
        bw.flush();
        bw.close();
    }

    static int[] bfs(char[][] map) {
        int[] answer = { 0, 0 };
        int[] moveR = { 0, 0, -1, 1 };
        int[] moveC = { -1, 1, 0, 0 };
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != '#') {
                    int numberOfO = 0;
                    int numberOfV = 0;
                    int[] start = { i, j };

                    if (map[start[0]][start[1]] == 'o') {
                        numberOfO++;
                    }
                    if (map[start[0]][start[1]] == 'v') {
                        numberOfV++;
                    }

                    q.offer(start);
                    map[start[0]][start[1]] = '#';
                    while (!q.isEmpty()) {
                        int[] current = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int[] temp = { current[0] + moveR[k], current[1] + moveC[k] };
                            if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[temp[0]].length) {
                                if (map[temp[0]][temp[1]] != '#') {
                                    if (map[temp[0]][temp[1]] == 'o') {
                                        numberOfO++;
                                    }
                                    if (map[temp[0]][temp[1]] == 'v') {
                                        numberOfV++;
                                    }
                                    q.offer(temp);
                                    map[temp[0]][temp[1]] = '#';
                                }
                            }
                        }
                    }
                    if (numberOfO > numberOfV) {
                        answer[0] += numberOfO;
                    } else {
                        answer[1] += numberOfV;
                    }
                }
            }
        }
        return answer;
    }
}