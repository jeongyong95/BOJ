package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// TODO : 다시 풀어야 함
public class Solution14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        dfs(0, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int index, int count) {
        if (count == visited.length / 2) {
            diff();
            return;
        }

        for (int i = index; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                if (answer == 0) {
                    return;
                }
                visited[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < visited.length - 1; i++) {
            for (int j = i + 1; j < visited.length; j++) {
                if (visited[i] && visited[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int difference = Math.abs(start - link);

        if (difference == 0) {
            answer = 0;
            return;
        }
        answer = Math.min(answer, difference);
    }
}