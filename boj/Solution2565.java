package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2565 {
    static int[] dp;
    static Wire[] wires;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n];
        wires = new Wire[n];
        for (int i = 0; i < wires.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            wires[i] = new Wire(a, b);
        }
        br.close();

        Arrays.sort(wires);
        dp();

        int max = 0;
        for (int i : dp) {
            if (max < i) {
                max = i;
            }
        }
        bw.write(n - max + "\n");
        bw.flush();
        bw.close();
    }

    static void dp() {
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (wires[i].b > wires[j].b) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
    }
}

// Longest Inscreasing Sequence
class Wire implements Comparable<Wire> {
    int a;
    int b;

    public Wire(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Wire o) {
        return this.a - o.a;
    }
}