import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution13565 {
    static char[][] map;
    static boolean[][] visited;
    static boolean possible = false;
    static int[] moveM = { 0, 0, -1, 1 };
    static int[] moveN = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();

        for (int i = 0; i < n; i++) {
            if (map[0][i] == '0') {
                int[] start = { 0, i };
                visited[0][i] = true;
                dfs(start);
                if (possible) {
                    break;
                }
            }
        }

        String answer = "NO";
        if (possible) {
            answer = "YES";
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int[] current) {
        if (current[0] == map.length - 1) {
            possible = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[] temp = { current[0] + moveM[i], current[1] + moveN[i] };
            if (temp[0] >= 0 && temp[0] < map.length && temp[1] >= 0 && temp[1] < map[temp[0]].length) {
                if (!visited[temp[0]][temp[1]] && map[temp[0]][temp[1]] == '0') {
                    visited[temp[0]][temp[1]] = true;
                    dfs(temp);
                    if (possible) {
                        return;
                    }
                }
            }
        }
    }
}
