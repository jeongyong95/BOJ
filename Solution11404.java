import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution11404 {
    static final int INF = 10_000_000;
    static int[][] map;
    static int[][] distance;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n][n];
        distance = new int[n][n];

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            if (map[a][b] != 0) {
                map[a][b] = map[a][b] > c ? c : map[a][b];
            } else {
                map[a][b] = c;
            }
        }
        br.close();

        floydWarshall();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(distance[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void floydWarshall() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else if (map[i][j] != 0) {
                    distance[i][j] = map[i][j];
                } else {
                    distance[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance.length; j++) {
                for (int k = 0; k < distance.length; k++) {
                    if (distance[j][k] > distance[j][i] + distance[i][k]) {
                        distance[j][k] = distance[j][i] + distance[i][k];
                    }
                }
            }
        }
    }
}