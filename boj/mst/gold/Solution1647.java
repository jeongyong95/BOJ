package boj.mst.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1647 {
    static int[] link;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        link = new int[n + 1];
        for (int i = 1; i < link.length; i++) {
            link[i] = i;
        }

        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, c);
        }
        br.close();
        Arrays.sort(edges);

        int answer = kruskal();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static int kruskal() {
        int answer = 0;
        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            if (!isSame(edge.start, edge.end)) {
                unite(edge.start, edge.end);
                if (max < edge.cost) {
                    max = edge.cost;
                }
                answer += edge.cost;
            }
        }
        return answer - max;
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

        if (a < b) {
            link[b] = a;
        } else if (a > b) {
            link[a] = b;
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