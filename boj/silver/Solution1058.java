package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1058 {
    static final int INF = 2_500;
    static char[][] map;
    static int[][] distance;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        distance = new int[n][n];

        for (int i = 0; i < map.length; i++) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();

        bw.write(floydWarshall() + "\n");
        bw.flush();
        bw.close();
    }

    static int floydWarshall() {
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance.length; j++) {
                if (map[i][j] == 'Y') {
                    distance[i][j] = 1;
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

        for (int i = 0; i < distance.length; i++) {
            distance[i][i] = INF;
        }

        int answer = 0;
        for (int i = 0; i < distance.length; i++) {
            int temp = 0;
            for (int j = 0; j < distance.length; j++) {
                if (distance[i][j] <= 2) {
                    temp++;
                }
            }
            if (answer < temp) {
                answer = temp;
            }
        }
        return answer;
    }
}
