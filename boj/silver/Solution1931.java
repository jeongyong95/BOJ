package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1931 {
    static PriorityQueue<Meetting> pq = new PriorityQueue<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Meetting(start, end));
        }
        br.close();

        int answer = 0;
        int end = 0;
        while (!pq.isEmpty()) {
            Meetting meetting = pq.poll();

            if (end <= meetting.start) {
                answer++;
                end = meetting.end;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}

class Meetting implements Comparable<Meetting> {
    int start;
    int end;

    public Meetting() {

    }

    public Meetting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meetting o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}