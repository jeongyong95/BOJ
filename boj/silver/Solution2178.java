package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] maze = new char[nm[0]][nm[1]];
        for (int i = 0; i < maze.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = line.charAt(j);
            }
        }
        br.close();

        bw.write(bfs(maze) + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(char[][] maze) {
        Queue<int[]> q = new LinkedList<>();
        int[][] distance = new int[maze.length][maze[0].length];
        int[] start = { 0, 0 };
        int[] moveN = { 0, 0, -1, 1 };
        int[] moveM = { -1, 1, 0, 0 };

        q.offer(start);
        distance[start[0]][start[1]] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < 4; i++) {
                int[] temp = { current[0] + moveN[i], current[1] + moveM[i] };
                if (temp[0] >= 0 && temp[0] < maze.length && temp[1] >= 0 && temp[1] < maze[temp[0]].length
                        && maze[temp[0]][temp[1]] == '1') {
                    q.offer(temp);
                    maze[temp[0]][temp[1]] = '0';
                    distance[temp[0]][temp[1]] = distance[current[0]][current[1]] + 1;
                }
            }
        }
        return distance[maze.length - 1][maze[0].length - 1];
    }
}
