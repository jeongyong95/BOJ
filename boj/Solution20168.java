package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution20168 {
    static final int INF = 100_001;
    static List<Node>[] map;
    static boolean[] visited;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int cash = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        distance = new int[n + 1][2];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a].add(new Node(b, c));
            map[b].add(new Node(a, c));
        }
        br.close();

        bw.write(dijkstra(start, end, cash) + "\n");
        bw.flush();
        bw.close();
    }

    static int dijkstra(int start, int end, int cash) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i < distance.length; i++) {
            distance[i][0] = INF;
        }
        distance[start][0] = 0;

        pq.offer(new Node(start, distance[1][0]));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.node;
            if (u == end) {
                return distance[u][1];
            }
            if (distance[u][0] < current.cost) {
                continue;
            }

            if (!visited[u]) {
                visited[u] = true;

                for (int i = 0, size = map[u].size(); i < size; i++) {
                    Node next = map[u].get(i);
                    int v = next.node;
                    int w = next.cost;

                    if (cash > distance[u][0] + w) {
                        distance[v][0] = distance[u][0] + w;
                        if (v == end && distance[v][1] != 0) {
                            int max = distance[u][1] > w ? distance[u][1] : w;
                            if (distance[v][1] > max) {
                                distance[v][1] = max;
                            }
                        }
                        distance[v][1] = distance[u][1] > w ? distance[u][1] : w;
                        pq.offer(new Node(v, distance[v][0]));
                    }
                }
            }
        }
        return -1;
    }
}

class Node implements Comparable<Node> {
    int node;
    int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }

}