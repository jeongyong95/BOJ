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

        do {
            st = new StringTokenizer(br.readLine());

            // w, h <= 50
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            int[][] map = new int[h][w];

            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            bw.write(bfs(map) + "\n");
        } while (w != 0 && h != 0);

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

        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[i].length - 1; j++) {
                int[] xy = { i, j };
                q.offer(xy);
                visited[i][j] = true;

                while (!q.isEmpty()) {
                    boolean isolationFlag = true;
                    int[] target = q.poll();
                    visited[target[0]][target[1]] = true;

                    for (int k = 0; k < searchDirection.length; k++) {
                        int x = target[0] + searchDirection[k][0];
                        int y = target[1] + searchDirection[k][1];
                        if (map[x][y] == 1 && visited[x][y]) {
                            isolationFlag = false;
                        }

                    }
                }
            }
        }

        return answer;
    }
}
