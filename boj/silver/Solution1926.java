package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        List<Integer> answer = bfs(map);

        int max = 0;
        for (int i : answer) {
            if (max < i) {
                max = i;
            }
        }
        bw.write(answer.size() + "\n");
        bw.write(max + "\n");
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
                    int size = 1;
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
                                    size++;
                                    map[temp[0]][temp[1]] = 0;
                                }
                            }
                        }
                    }
                    answer.add(size);
                }
            }
        }
        return answer;
    }
}
