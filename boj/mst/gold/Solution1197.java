package boj.mst.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1197 {
    static int[] link;
    static Edge[] edgeArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        link = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            link[i] = i;
        }

        edgeArr = new Edge[e];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeArr[i] = new Edge(a, b, c);
        }
        br.close();
        Arrays.sort(edgeArr);

        int answer = kruskal();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static int kruskal() {
        int answer = 0;
        for (int i = 0; i < edgeArr.length; i++) {
            Edge edge = edgeArr[i];
            if (!isSame(edge.start, edge.end)) {
                unite(edge.start, edge.end);
                answer += edge.cost;
            }
        }
        return answer;
    }

    static int find(int x) {
        if (x == link[x])
            return x;
        return link[x] = find(link[x]);
    }

    static void unite(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            link[a] = b;
        } else if (a < b) {
            link[b] = a;
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