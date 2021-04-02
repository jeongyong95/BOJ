import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        int[][] map = new int[n][m];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.valueOf(st.nextToken()) - 1;
            int c = Integer.valueOf(st.nextToken()) - 1;

            map[r][c] = 1;
        }
        br.close();

        bw.write(bfs(map) + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(int[][] map) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int[] moveN = { 0, 0, -1, 1 };
        int[] moveM = { -1, 1, 0, 0 };

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    int[] start = { i, j };
                    int size = 0;

                    q.offer(start);
                    map[i][j] = 0;
                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        size++;

                        for (int k = 0; k < 4; k++) {
                            int[] temp = { current[0] + moveN[k], current[1] + moveM[k] };
                            if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[temp[0]].length) {
                                if (map[temp[0]][temp[1]] == 1) {
                                    q.offer(temp);
                                    map[temp[0]][temp[1]] = 0;
                                }
                            }
                        }
                    }
                    if (answer < size) {
                        answer = size;
                    }
                }
            }
        }
        return answer;
    }
}