package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        br.close();

        bw.write(bfs(a, b) + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(long a, long b) {
        int answer = -1;
        Map<Long, Integer> distance = new HashMap<>();
        Queue<Long> q = new LinkedList<>();

        q.offer(a);
        distance.put(a, 0);
        while (!q.isEmpty()) {
            long current = q.poll();
            long nextDouble = current * 2;
            long appendOne = current * 10 + 1;
            int nextDistance = distance.get(current) + 1;

            if (nextDouble <= b) {
                q.offer(nextDouble);
                distance.put(nextDouble, nextDistance);
            }
            if (appendOne <= b) {
                q.offer(appendOne);
                distance.put(appendOne, nextDistance);
            }

            if (distance.containsKey(b)) {
                return distance.get(b) + 1;
            }
        }
        return answer;
    }
}
