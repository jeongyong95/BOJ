import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] adj;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int m = input[1];
        int v = input[2];

        distance = new int[n + 1];
        visited = new boolean[n + 1];
        adj = new int[n + 1][n + 1];

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            adj[i][j] = 1;
            adj[j][i] = 1;
        }
        br.close();

        dfs(v);
        bw.write("\n");
        Arrays.fill(visited, false);

        bfs(v);

        bw.flush();
        bw.close();
    }

    // 1. 정점을 방문했는지 확인한다.
    // 2. 방문 안했으면 방문표시하고 할 작업 한다.
    // 3. 배열을 순회한다.
    static void dfs(int v) throws IOException {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        bw.write(v + " ");
        for (int i = 1; i < adj[v].length; i++) {
            if (adj[v][i] == 1) {
                dfs(i);
            }
        }
    }

    // 1. 시작점을 큐에 넣는다. 방문 체크. 거리 0 세팅
    // 2. 큐가 빌때까지 반복문을 순회한다.
    // 3. 큐에서 값을 빼고 출력한다.
    // 4. 꺼낸 값의 인접리스트/행렬을 순회하며 방문체크, 거리 증가, 큐에 넣는다.
    static void bfs(int v) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.offer(v);
        distance[v] = 0;

        while (!q.isEmpty()) {
            int s = q.peek();
            q.poll();
            bw.write(s + " ");

            for (int i = 1; i < adj[s].length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (adj[s][i] == 1) {
                    visited[i] = true;
                    distance[i] = distance[s] + 1;
                    q.offer(i);
                }
            }
        }
    }
}
