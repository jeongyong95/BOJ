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

public class Solution17396 {
    static final long INF = 100_000l * 100_000l;
    static List<Node>[] map;
    static boolean[] visited;
    static int[] isPossible;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        visited = new boolean[n];
        distance = new long[n];

        st = new StringTokenizer(br.readLine());
        isPossible = new int[n];
        for (int i = 0; i < n; i++) {
            isPossible[i] = Integer.parseInt(st.nextToken());

        }
        isPossible[n - 1] = 0;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            map[a].add(new Node(b, t));
            map[b].add(new Node(a, t));

        }
        br.close();

        long answer = dijkstra();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static long dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < distance.length; i++) {
            distance[i] = INF;
        }
        distance[0] = 0;
        pq.offer(new Node(0, distance[0]));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.node;
            if (current.node == distance.length - 1) {
                return distance[distance.length - 1];
            }
            if (distance[u] < current.cost) {
                continue;
            }

            if (!visited[u]) {
                visited[u] = true;
                List<Node> adjList = map[u];
                for (int i = 0, size = adjList.size(); i < size; i++) {
                    Node next = adjList.get(i);
                    int v = next.node;
                    long w = next.cost;
                    if (isPossible[v] == 0 && distance[v] > distance[u] + w) {
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
    long cost;

    public Node(int node, long cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost == o.cost) {
            return 0;
        } else {
            return -1;
        }
    }
}