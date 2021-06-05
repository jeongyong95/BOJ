package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    private int v;
    private int distance;

    public Pair(int v, int distance) {
        this.v = v;
        this.distance = distance;
    }

    @Override
    public int compareTo(Pair o) {
        return this.distance - o.getDistance();
    }

    public int getV() {
        return v;
    }

    public int getDistance() {
        return distance;
    }
}

public class Solution1753 {
    static final int INF = 3_000_000;
    static Map<Integer, List<int[]>> graph = new HashMap<>();
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            graph.put(i, new ArrayList<>());
        }

        int start = Integer.parseInt(br.readLine());
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int[] edge = new int[2];
            edge[0] = v;
            edge[1] = w;

            graph.get(u).add(edge);
        }
        br.close();

        dijkstra(start);
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(distance[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.offer(new Pair(start, distance[start]));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int current = pair.getV();
            if (!visited[current]) {
                visited[current] = true;

                List<int[]> adjList = graph.get(current);
                for (int i = 0, size = adjList.size(); i < size; i++) {
                    int[] next = adjList.get(i);
                    if (distance[next[0]] > distance[current] + next[1]) {
                        distance[next[0]] = distance[current] + next[1];
                        pq.offer(new Pair(next[0], distance[next[0]]));
                    }
                }
            }
        }
    }
}
