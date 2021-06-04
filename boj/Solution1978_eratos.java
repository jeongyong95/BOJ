package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1978_eratos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        br.close();

        int cnt = 0;

        for (int i = 0; i < input.length; i++) {
            if (isPrimeNumber(Integer.parseInt(input[i]))) {
                cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    // 소수 찾기, ~까지의 소수의 개수 구하기에서 최상의 방법 - 에라토스테네스의 체
    static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        boolean check[] = new boolean[n + 1];
        Arrays.fill(check, true);
        for (int i = 2; i <= n; i++) {
            if (check[i] == true) {
                for (int j = i + i; j <= n; j += i) {
                    check[j] = false;
                }
            }
        }
        return check[n];
    }
}