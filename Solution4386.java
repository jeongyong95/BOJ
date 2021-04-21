import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution4386 {
    static int[] link;
    static double[][] stars;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        stars = new double[n][2];
        link = new int[n];
        for (int i = 0; i < link.length; i++) {
            link[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }
        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distPow = Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2);
                pq.offer(new Edge(i, j, Math.sqrt(distPow)));
            }
        }

        double answer = kruskal();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
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