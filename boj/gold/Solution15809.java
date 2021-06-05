package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution15809 {
    static int[][] link;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> resultSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        link = new int[n + 1][2];
        for (int i = 1; i < link.length; i++) {
            int power = Integer.parseInt(br.readLine());
            link[i][0] = i;
            link[i][1] = power;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int history = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            unite(history, a, b);
        }
        br.close();

        for (int i = 1; i <= n; i++) {
            link[i][0] = find(link[i][0]);
        }

        for (int i = 1; i < link.length; i++) {
            if (link[i][0] != 0) {
                resultSet.add(link[i][0]);
            }
        }
        int index = 0;
        int[] powerArr = new int[resultSet.size()];
        for (Integer i : resultSet) {
            powerArr[index++] = link[i][1];
        }
        Arrays.sort(powerArr);

        bw.write(resultSet.size() + "\n");
        for (int i = 0; i < powerArr.length; i++) {
            bw.write(powerArr[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    static int find(int x) {
        if (x == link[x][0]) {
            return x;
        }
        return link[x][0] = find(link[x][0]);
    }

    static void unite(int history, int a, int b) {
        a = find(a);
        b = find(b);

        int powerResult = 0;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (history == 2) {
            powerResult = Math.abs(link[a][1] - link[b][1]);
            if (powerResult == 0) {
                link[a][0] = 0;
                link[b][0] = 0;
            } else {
                link[max][0] = min;
            }
            link[min][1] = powerResult;
        } else {
            powerResult = link[a][1] + link[b][1];
            if (a != b) {
                link[max][0] = min;
            }
            link[min][1] = powerResult;
        }
    }

    static boolean isSame(int a, int b) {
        return find(a) == find(b);
    }
}
