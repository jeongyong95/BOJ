package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1833 {
    static int total = 0;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    static int[] link;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        link = new int[n + 1];
        for (int i = 1; i < link.length; i++) {
            link[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (j > i) {
                    if (c < 0) {
                        c = -c;
                        total += c;
                        unite(i, j);
                    }
                    pq.offer(new Edge(i, j, c));
                }
            }
        }
        br.close();

        kruskal();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void kruskal() {
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (!isSame(current.start, current.end)) {
                unite(current.start, current.end);
                sb.append(current.start + " ").append(current.end + "\n");
                total += current.cost;
                count++;
            }
        }
        sb.insert(0, total + " " + count + "\n");
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
        link[Math.max(a, b)] = Math.min(a, b);
    }

    static boolean isSame(int a, int b) {
        return find(a) == find(b);
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int cost;

    public Edge() {

    }

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}