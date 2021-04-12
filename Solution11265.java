import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution11265 {
    static final int INF = 500_000_000;
    static int[][] partyRooms;
    static long[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        partyRooms = new int[n][n];
        dist = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                partyRooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        floydWarshall();

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            if (dist[a][b] > c) {
                sb.append("Stay here\n");
            } else {
                sb.append("Enjoy other party\n");
            }
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void floydWarshall() {
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (partyRooms[i][j] != 0) {
                    dist[i][j] = partyRooms[i][j];
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                for (int k = 0; k < dist.length; k++) {
                    if (dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
    }
}