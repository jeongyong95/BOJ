package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7562 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] moveN = { -2, -2, -1, -1, 1, 1, 2, 2 };
        int[] moveM = { -1, 1, -2, 2, -2, 2, -1, 1 };
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int i = Integer.parseInt(br.readLine());
            int[][] map = new int[i][i];
            int[][] distance = new int[i][i];
            Queue<int[]> q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

            st = new StringTokenizer(br.readLine());
            int[] target = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

            q.offer(start);
            distance[start[0]][start[1]] = 0;
            map[start[0]][start[1]] = 1;

            while (!q.isEmpty()) {
                if (map[target[0]][target[1]] == 1) {
                    bw.write(distance[target[0]][target[1]] + "\n");
                    break;
                }
                int[] current = q.poll();

                for (int j = 0; j < 8; j++) {
                    int[] temp = { current[0] + moveN[j], current[1] + moveM[j] };
                    if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[temp[0]].length) {
                        if (map[temp[0]][temp[1]] == 1) {
                            continue;
                        }
                        q.offer(temp);
                        map[temp[0]][temp[1]] = 1;
                        distance[temp[0]][temp[1]] = distance[current[0]][current[1]] + 1;
                    }
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}