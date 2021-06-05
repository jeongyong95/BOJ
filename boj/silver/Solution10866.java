package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Solution10866 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    if (!dq.isEmpty()) {
                        bw.write(dq.pollFirst() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "pop_back":
                    if (!dq.isEmpty()) {
                        bw.write(dq.pollLast() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                case "front":
                    if (!dq.isEmpty()) {
                        bw.write(dq.peekFirst() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "back":
                    if (!dq.isEmpty()) {
                        bw.write(dq.peekLast() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
