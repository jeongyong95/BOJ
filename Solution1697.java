import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1697 {
    static boolean[] arr = new boolean[100001];
    static int[] distance = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = bfs(n, k);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        arr[start] = true;

        while (!arr[target]) {
            int current = q.poll();
            int twice = current * 2;
            int previous = current - 1;
            int next = current + 1;

            if (twice < arr.length && !arr[twice]) {
                q.offer(twice);
                arr[twice] = true;
                distance[twice] = distance[current] + 1;
            }
            if (previous >= 0 && !arr[previous]) {
                q.offer(previous);
                arr[previous] = true;
                distance[previous] = distance[current] + 1;
            }
            if (next < arr.length && !arr[next]) {
                q.offer(next);
                arr[next] = true;
                distance[next] = distance[current] + 1;
            }
        }
        return distance[target];
    }
}