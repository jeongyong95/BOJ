import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1504 {
    static final int INF = Integer.MAX_VALUE;
    static int[][] adj;
    static long[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        adj = new int[n + 1][n + 1];
        dist = new long[n + 1][n + 1];

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a][b] = c;
            adj[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        br.close();

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        floydWarshall();
        long answer = dist[1][v1] + dist[v1][v2] + dist[v2][n];
        if (answer > dist[1][v2] + dist[v1][v2] + dist[v1][n]) {
            answer = dist[1][v2] + dist[v1][v2] + dist[v1][n];
        }
        if (answer >= INF) {
            answer = -1;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void floydWarshall() {
        for (int i = 1; i < adj.length; i++) {
            for (int j = 1; j < adj.length; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (adj[i][j] != 0) {
                    dist[i][j] = adj[i][j];
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 1; i < adj.length; i++) {
            for (int j = 1; j < adj.length; j++) {
                for (int k = 1; k < adj.length; k++) {
                    if (dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
    }
}