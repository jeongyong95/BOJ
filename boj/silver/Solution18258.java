package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution18258 {
    static Deque<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            operateQ(st);
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void operateQ(StringTokenizer st) {
        String operation = st.nextToken();

        switch (operation) {
            case "push":
                q.offer(Integer.parseInt(st.nextToken()));
                break;
            case "pop":
                if (q.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(q.poll() + "\n");
                }
                break;
            case "size":
                sb.append(q.size() + "\n");
                break;
            case "empty":
                if (q.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
                break;
            case "front":
                if (q.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(q.peekFirst() + "\n");
                }
                break;
            default:
                if (q.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(q.peekLast() + "\n");
                }
                break;
        }
    }
}