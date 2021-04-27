import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1987 {
    static int answer = 0;
    static char[][] map;
    static boolean[] visited;
    static int[] moveR = { 0, 0, -1, 1 };
    static int[] moveC = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        visited = new boolean['Z' + 1];
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        br.close();

        dfs(0, 0, 1);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    // 개인적으로 DFS가 BFS보다 더 어렵다:(
    static void dfs(int r, int c, int dist) {
        visited[map[r][c]] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + moveR[i];
            int nc = c + moveC[i];

            if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[nr].length) {
                if (!visited[map[nr][nc]]) {
                    dfs(nr, nc, dist + 1);
                }
            }
        }

        visited[map[r][c]] = false;
        if (answer < dist) {
            answer = dist;
        }
    }
}
