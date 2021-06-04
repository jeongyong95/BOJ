package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution9020 {
    static boolean[] isPrime = new boolean[10001];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < isPrime.length; i++) {
            for (int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }
        isPrime[0] = false;
        isPrime[1] = false;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = n / 2; i >= 2; i--) {
                if (isPrime[i] && isPrime[n - i]) {
                    sb.append(i).append(' ').append(n - i + "\n");
                    break;
                }
            }
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
