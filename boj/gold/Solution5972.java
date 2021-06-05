package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution5972 {
    static final int INF = 50_000_000;
    static List<Node>[] map;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        distance = new int[n + 1];
        map = new ArrayList[n + 1];
        for (int i = 1; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a].add(new Node(b, c));
            map[b].add(new Node(a, c));
        }
        br.close();

        bw.write(dijkstra() + "\n");
        bw.flush();
        bw.close();
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i < distance.length; i++) {
            distance[i] = INF;
        }
        distance[1] = 0;
        pq.offer(new Node(1, distance[1]));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.node;

            if (u == distance.length - 1) {
                return distance[u];
            }
            if (distance[u] < current.cost) {
                continue;
            }

            if (!visited[u]) {
                visited[u] = true;
                for (int i = 0, size = map[u].size(); i < size; i++) {
                    Node next = map[u].get(i);
                    int v = next.node;
                    int w = next.cost;
                    if (distance[v] > distance[u] + w) {
                        distance[v] = distance[u] + w;
                        pq.offer(new Node(v, distance[v]));
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