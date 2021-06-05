package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution2210 {
    static Set<Integer> resultSet = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int[] result = new int[6];
    static int[][] map = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] moveN = { 0, 0, -1, 1 };
    static int[] moveM = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int[] start = { i, j };
                result[0] = map[i][j];
                dfs(start, 0);
            }
        }

        bw.write(resultSet.size() + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int[] current, int index) {
        if (index == 6) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]);
            }
            resultSet.add(Integer.parseInt(sb.toString()));
            sb = new StringBuilder();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[] temp = { current[0] + moveN[i], current[1] + moveM[i] };
            if (temp[0] >= 0 && temp[0] < 5 && temp[1] >= 0 && temp[1] < 5) {
                result[index] = map[temp[0]][temp[1]];
                dfs(temp, index + 1);
            }
        }
    }
}