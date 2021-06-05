package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution1916 {
    static int[][] map;
    static int[] distance;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new int[m][3];
        distance = new int[n + 1];

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            int[] edge = new int[3];
            edge[0] = start;
            edge[1] = end;
            edge[2] = cost;
            map[m] = edge;
        }
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int answer = bellmanFord(start, end);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static int bellmanFord(int start, int end) {
        Arrays.fill(distance, 100_000_000);
        distance[start] = 0;

        for (int i = 1, size = distance.length - 1; i < size; i++) {
            for (int j = 0; j < map.length; j++) {
                int current = map[j][0];
                int target = map[j][1];
                int cost = map[j][2];

                int temp = distance[current] + cost;
                if (distance[target] > temp) {
                    distance[target] = temp;
                } else if (distance[target] == temp && target == end) {
                    return distance[end];
                }
            }
        }
        return distance[end];
    }
}