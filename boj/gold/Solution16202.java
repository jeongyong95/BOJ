package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution16202 {
    static int[] link;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        link = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a, b, i));
        }
        br.close();

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < link.length; j++) {
                link[j] = j;
            }
            if (i > 1) {
                pq.poll();
            }
            sb.append(kruskal(new PriorityQueue<Edge>(pq)) + " ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int kruskal(PriorityQueue<Edge> pq) {
        int answer = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (!isSame(current.start, current.end)) {
                unite(current.start, current.end);
                answer += current.cost;
            }
        }

        boolean possible = true;
        for (int i = 1; i < link.length - 1; i++) {
            if (!isSame(i, i + 1)) {
                possible = false;
                break;
            }
        }

        if (possible) {
            return answer;
        } else {
            return 0;
        }
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