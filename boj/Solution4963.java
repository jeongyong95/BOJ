package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4963 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int w, h;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            bw.write(bfs(map) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static int bfs(int[][] map) {
        int answer = 0;
        int[] moveH = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] moveW = { -1, 0, 1, -1, 1, -1, 0, 1 };

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    int[] start = { i, j };
                    q.offer(start);
                    map[i][j] = 0;

                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        for (int k = 0; k < 8; k++) {
                            int[] temp = { current[0] + moveH[k], current[1] + moveW[k] };
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
        }
        return answer;
    }
}
