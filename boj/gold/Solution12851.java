package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution12851 {
    static boolean[] visited = new boolean[100_001];
    static int count = 0;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        bfs(n, k);
        bw.write(time + "\n" + count + "\n");
        bw.flush();
        bw.close();
    }

    static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();

        time--;
        q.offer(start);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int current = q.poll();
                if (current == target) {
                    count++;
                }
                visited[current] = true;

                if (current - 1 >= 0 && !visited[current - 1]) {
                    q.offer(current - 1);
                }
                if (current + 1 <= 100_000 && !visited[current + 1]) {
                    q.offer(current + 1);
                }
                if (current * 2 <= 100_000 && !visited[current * 2]) {
                    q.offer(current * 2);
                }
            }
            time++;
            if (count > 0) {
                return;
            }
        }
    }
}