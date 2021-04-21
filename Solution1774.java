import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1774 {
    static int[] link;
    static long[][] map;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        link = new int[n + 1];
        for (int i = 1; i < link.length; i++) {
            link[i] = i;
        }

        map = new long[n + 1][2];
        for (int i = 1; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            map[i][0] = x;
            map[i][1] = y;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                long x = map[i][0] - map[j][0];
                long y = map[i][1] - map[j][1];
                long distPow = x * x + y * y;
                pq.offer(new Edge(i, j, Math.sqrt(distPow)));
            }
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            unite(a, b);
        }
        br.close();

        double answer = kruskal();
        System.out.printf("%.2f", (double) Math.round(answer * 100) / 100);
    }

    static double kruskal() {
        double answer = 0;
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (!isSame(current.start, current.end)) {
                unite(current.start, current.end);
                answer += current.cost;
            }
        }
        return answer;
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
    double cost;

    public Edge() {
    }

    public Edge(int start, int end, double cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost < o.cost) {
            return -1;
        }
        return 0;
    }
}
