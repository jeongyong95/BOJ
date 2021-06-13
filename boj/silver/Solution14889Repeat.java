package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 스타트와 링크 다시 풀기
public class Solution14889Repeat {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] statMap;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        statMap = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                statMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        dfs(0, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    // 선수단 조합 만들기
    static void dfs(int index, int depth) {
        if (depth == visited.length / 2) {
            solveDiff();
            return;
        }

        for (int i = index; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                if (answer == 0) {
                    return;
                }
                visited[i] = false;
            }
        }
    }

    // 차이의 최솟값 계산
    static void solveDiff() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < visited.length - 1; i++) {
            for (int j = i + 1; j < visited.length; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += statMap[i][j];
                    startTeam += statMap[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += statMap[i][j];
                    linkTeam += statMap[j][i];
                }
            }
        }

        int diff = Math.abs(startTeam - linkTeam);
        if (diff == 0) {
            answer = 0;
            return;
        }
        answer = Math.min(answer, diff);
    }
}
