import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2606 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfNode = Integer.parseInt(br.readLine());
        int numberOfEdge = Integer.parseInt(br.readLine());

        int[][] map = new int[numberOfNode + 1][numberOfNode + 1];
        while (numberOfEdge-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }
        br.close();

        bw.write(bfs(1, map) + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(int start, int[][] map) {
        int answer = 0;
        boolean[] visited = new boolean[map.length];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int target = q.poll();
            for (int i = 1; i < map[target].length; i++) {
                if (!visited[i] && map[target][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }

        return answer;
    }
}