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
        int[][] searchDirection = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 },
                { -1, 1 } };
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> q = new LinkedList<>();

        // 0,0부터 값이 1이면 큐에 넣는다.
        // 인접한 부분이 방문되었으면 넘어가고 방문되지 않았으면 고립된 섬이므로 체크한다

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int[] start = { i, j };
                    q.offer(start);
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] current = q.poll();

                        for (int k = 0; k < searchDirection.length; k++) {
                            int x = current[0] + searchDirection[k][0];
                            int y = current[1] + searchDirection[k][1];
                            if (x > map.length - 1 || x < 0 || y > map[x].length - 1 || y < 0) {
                                continue;
                            }
                            if (map[x][y] == 1) {
                                int[] next = { x, y };
                                q.offer(next);
                                visited[x][y] = true;
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
