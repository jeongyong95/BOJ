package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll() + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
