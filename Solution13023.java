import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution13023 {
    // 틀렸다. 다시 풀기
    public static class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        Integer n = Integer.parseInt(nm[0]);
        Integer m = Integer.parseInt(nm[1]);

        boolean[][] adjacencyMatrix = new boolean[n][n];
        List<Integer>[] adjacencyList = (ArrayList<Integer>[]) new ArrayList[n];
        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);
            edgeList.add(new Edge(from, to));
            edgeList.add(new Edge(to, from));
            adjacencyMatrix[from][to] = true;
            adjacencyMatrix[to][from] = true;
            adjacencyList[from].add(to);
            adjacencyList[to].add(from);
        }
        br.close();

        m *= 2;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                Integer a = edgeList.get(i).from;
                Integer b = edgeList.get(i).to;
                Integer c = edgeList.get(j).from;
                Integer d = edgeList.get(j).to;

                if (a == b || a == c || a == d || b == c || b == d || c == d) {
                    continue;
                }
                if (!adjacencyMatrix[b][c]) {
                    continue;
                }

                for (int k = 0; k < adjacencyList[d].size(); k++) {
                    Integer e = adjacencyList[d].get(k);
                    if (a == e || b == e || c == e || d == e) {
                        continue;
                    }
                    bw.write(1 + "\n");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        bw.write(0 + "\n");
        bw.flush();
        bw.close();
    }
}