import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution14496 {
    static List<Integer>[] map;
    static int[] distance;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = INF;
            map[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start].add(end);
            map[end].add(start);
        }
        br.close();

        int answer = dijkstra(a, b);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, distance[start]));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int v = current.node;
            visited[v] = true;
            List<Integer> adjList = map[v];
            for (Integer i : adjList) {
                if (!visited[i] && distance[i] > distance[v] + 1) {
                    distance[i] = distance[v] + 1;
                    pq.offer(new Node(i, distance[i]));
                }
            }
            if (visited[end]) {
                return distance[end];
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