import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution13549 {
    static int[] distance = new int[100_001];
    static boolean[] visited = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        dijkstra(n, k);
        bw.write(distance[k] + "\n");
        bw.flush();
        bw.close();
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < distance.length; i++) {
            distance[i] = 100_001;
        }
        distance[start] = 0;
        pq.offer(new Node(start, distance[start]));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int v = current.node;
            visited[v] = true;

            if (v - 1 >= 0 && !visited[v - 1]) {
                if (distance[v - 1] > distance[v] + 1) {
                    distance[v - 1] = distance[v] + 1;
                    pq.offer(new Node(v - 1, distance[v - 1]));
                }
            }
            if (v + 1 <= 100_000 && !visited[v + 1]) {
                if (distance[v + 1] > distance[v] + 1) {
                    distance[v + 1] = distance[v] + 1;
                    pq.offer(new Node(v + 1, distance[v + 1]));
                }
            }
            if (v * 2 <= 100_000 && !visited[v * 2]) {
                if (distance[v * 2] > distance[v]) {
                    distance[v * 2] = distance[v];
                    pq.offer(new Node(v * 2, distance[v * 2]));
                }
            }

            if (visited[end]) {
                return;
            }
        }
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