import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution14716 {
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;

    static int[] moveM = { 0, 0, -1, -1, -1, 1, 1, 1 };
    static int[] moveN = { -1, 1, -1, 0, 1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int[] start = { i, j };
                    dfs(start);
                    answer++;
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int[] current) {
        for (int i = 0; i < 8; i++) {
            int[] temp = { current[0] + moveM[i], current[1] + moveN[i] };
            if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[temp[0]].length) {
                if (map[temp[0]][temp[1]] == 1 && !visited[temp[0]][temp[1]]) {
                    visited[temp[0]][temp[1]] = true;
                    dfs(temp);
                }
            }
        }
    }
}
