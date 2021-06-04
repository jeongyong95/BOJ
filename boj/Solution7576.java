package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7576 {
    static int remain = 0;
    static Queue<int[]> q = new LinkedList<>();

    // 메모리랑 시간 너무 많이 씀.
    // todo : 다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 동시에 익는다
        char[][] stock = new char[n][m];
        for (int i = 0; i < stock.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < stock[i].length; j++) {
                stock[i][j] = st.nextToken().charAt(0);
                if (stock[i][j] == '0') {
                    remain++;
                } else if (stock[i][j] == '1') {
                    int[] start = { i, j };
                    q.offer(start);
                }
            }
        }
        br.close();

        bw.write(bfs(stock) + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(char[][] stock) {
        int answer = 0;
        int[] moveN = { 0, 0, -1, 1 };
        int[] moveM = { -1, 1, 0, 0 };
        int cycle = q.size();

        while (!q.isEmpty()) {
            if (cycle == 0) {
                answer++;
                cycle = q.size();
            }
            int[] current = q.poll();
            cycle--;
            for (int i = 0; i < 4; i++) {
                int[] temp = { current[0] + moveN[i], current[1] + moveM[i] };
                if (temp[0] >= 0 && temp[0] < stock.length && temp[1] >= 0 && temp[1] < stock[temp[0]].length) {
                    if (stock[temp[0]][temp[1]] == '0') {
                        stock[temp[0]][temp[1]] = '1';
                        q.offer(temp);
                        remain--;
                    }
                }
            }
        }

        if (remain > 0) {
            return -1;
        }

        return answer;
    }
}
