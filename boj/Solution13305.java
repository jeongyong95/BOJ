package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution13305 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] dist = new long[n - 1];
        long[] prices = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }
        br.close();

        long answer = 0;
        long price = prices[0];
        for (int i = 0; i < dist.length; i++) {
            answer += price * dist[i];
            if (price > prices[i + 1]) {
                price = prices[i + 1];
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
