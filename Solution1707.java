import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution1707 {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] dist;
    static int[] link;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            link = new int[v + 1];
            for (int i = 1; i < link.length; i++) {
                link[i] = i;
            }

            adj = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                adj[i] = new ArrayList<>();
            }
            dist = new int[adj.length];
            visited = new boolean[adj.length];

            while (e-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                adj[b].add(a);
                unite(a, b);
            }
            bfs();
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Set<Integer> startSet = new HashSet<>();
        for (int i = 1; i < link.length; i++) {
            startSet.add(find(link[i]));
        }

        for (Integer i : startSet) {
            dist[i] = 1;
            visited[i] = true;
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            for (Integer i : adj[current]) {
                if (visited[i]) {
                    if (dist[current] == dist[i]) {
                        sb.append("NO\n");
                        q.clear();
                        return;
                    }
                } else {
                    dist[i] = dist[current] * -1;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        sb.append("YES\n");
    }

    static int find(int x) {
        if (x == link[x]) {
            return x;
        }
        return link[x] = find(link[x]);
    }

    static void unite(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            link[Math.max(a, b)] = Math.min(a, b);
        }
    }
}
