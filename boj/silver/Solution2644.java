package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2644 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());

        int[][] familyTree = new int[n + 1][n + 1];
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            familyTree[x][y] = 1;
            familyTree[y][x] = 1;
        }
        br.close();

        int answer = bfs(familyTree, target);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(int[][] familyTree, int[] target) {
        int[] distance = new int[familyTree.length];
        boolean[] visited = new boolean[familyTree.length];
        Queue<Integer> q = new LinkedList<>();

        q.offer(target[0]);
        visited[target[0]] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 1; i < familyTree[current].length; i++) {
                if (!visited[i] && familyTree[current][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                    distance[i] = distance[current] + 1;
                }
            }
            if (visited[target[1]] == true) {
                return distance[target[1]];
            }
        }
        return -1;
    }
}