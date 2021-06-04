package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution9205 {
    static final int INF = 15_000_000;
    static Place[] place;
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            place = new Place[n + 2];
            map = new int[n + 2][n + 2];
            dist = new int[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                place[i] = new Place(x, y);
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (i != j) {
                        map[i][j] = place[i].getDistance(place[j]);
                    }
                }
            }
            floydWarshall();
            if (dist[0][n + 1] == INF) {
                sb.append("sad\n");
            } else {
                sb.append("happy\n");
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
                } else if (map[i][j] > 1000) {
                    dist[i][j] = INF;
                } else {
                    dist[i][j] = map[i][j];
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                for (int k = 0; k < dist.length; k++) {
                    if (dist[j][i] <= 1000 && dist[i][k] <= 1000) {
                        if (dist[j][k] > dist[j][i] + dist[i][k]) {
                            dist[j][k] = 1000;
                        }
                    }
                }
            }
        }
    }
}

class Place {
    int x;
    int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Place o) {
        int xDistance = this.x - o.x;
        int yDistance = this.y - o.y;
        if (xDistance < 0) {
            xDistance *= -1;
        }
        if (yDistance < 0) {
            yDistance *= -1;
        }
        return xDistance + yDistance;
    }
}