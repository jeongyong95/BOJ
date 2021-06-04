package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1978_repeat_v3 {
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

    // 루트 n까지만 탐색하는 반복문 --> 반복문으로는 최상의 방법, 수의 약수가 좌우로 대칭임을 이용, 루트 n까지의 약수가 없다면 이 수는
    // 소수
    static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}