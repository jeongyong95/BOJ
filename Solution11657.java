import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution11657 {
    static long INF = Long.MAX_VALUE / 2;
    static Edge[] adj;
    static long[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];
        adj = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adj[i] = new Edge(a, b, c);
        }
        br.close();

        bellmanFord();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void bellmanFord() {
        for (int i = 2; i < dist.length; i++) {
            dist[i] = INF;
        }
        dist[1] = 0;

        int round = dist.length - 1;
        for (int i = 1; i <= round; i++) {
            for (int j = 0; j < adj.length; j++) {
                Edge edge = adj[j];
                // 현재 지점이 INF이면 도달할 수 없다는 이야기인데, 해당 간선이 음수 간선이면 연산이 된다.
                if (dist[edge.u] != INF && dist[edge.v] > dist[edge.u] + edge.w) {
                    dist[edge.v] = dist[edge.u] + edge.w;
                    if (i == round) {
                        sb.append("-1\n");
                        return;
                    }
                }
            }
        }

        for (int i = 2; i < dist.length; i++) {
            if (dist[i] == INF) {
                sb.append("-1\n");
            } else {
                sb.append(dist[i] + "\n");
            }
        }
    }
}

class Edge {
    int u;
    int v;
    long w;

    public Edge() {

    }

    public Edge(int u, int v, long w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}