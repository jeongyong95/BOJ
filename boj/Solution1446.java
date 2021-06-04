package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1446 {
    static final int INF = Integer.MAX_VALUE;
    static Map<Integer, List<Node>> map = new HashMap<>();
    static boolean[] visited = new boolean[10_001];
    static int[] distance = new int[10_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.put(start, map.getOrDefault(start, new ArrayList<>()));
            map.get(start).add(new Node(end, cost));
        }
        br.close();

        int answer = dijkstra(d);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static int dijkstra(int target) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < distance.length; i++) {
            distance[i] = INF;
        }
        distance[0] = 0;
        pq.offer(new Node(0, distance[0]));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int v = current.node;
            int w = current.cost;
            if (target == v) {
                return distance[v];
            }
            visited[v] = true;

            if (map.containsKey(v)) {
                List<Node> shortRoot = map.get(v);
                for (int i = 0, size = shortRoot.size(); i < size; i++) {
                    Node next = shortRoot.get(i);
                    if (!visited[next.node] && distance[next.node] > distance[v] + next.cost) {
                        distance[next.node] = distance[v] + next.cost;
                        pq.offer(new Node(next.node, distance[next.node]));
                    }
                }
            }
            if (!visited[v + 1] && distance[v + 1] > distance[v] + 1) {
                distance[v + 1] = distance[v] + 1;
                pq.offer(new Node(v + 1, distance[v + 1]));
            }
        }
        return distance[target];
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
