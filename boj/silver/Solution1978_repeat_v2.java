package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1978_repeat_v2 {
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

    // n/2까지만 탐색하는 반복문 --> 이 구간에서 약수가 존재하지 않는다면 n/2 ~ n-1까지의 범위 역시 약수가 존재하지 않음
    static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}