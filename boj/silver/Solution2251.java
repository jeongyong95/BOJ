package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// TODO : 풀어야 함
public class Solution2251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Set<Integer> answer = bfs(a, b, c);
        for (Integer i : answer) {
            bw.write(i + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    static Set<Integer> bfs(int a, int b, int c) {
        Set<Integer> answer = new TreeSet<>();
        boolean[][][] visited = new boolean[a + 1][b + 1][c + 1];
        Queue<int[]> q = new LinkedList<>();
        int[] start = { 0, 0, c };
        q.offer(start);
        visited[0][0][c] = true;

        return answer;
    }
}
