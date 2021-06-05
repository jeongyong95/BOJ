package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1934_repeat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer t = Integer.parseInt(br.readLine());
        Integer gcd = 0;
        Integer lcm = 0;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            Integer a = Integer.parseInt(input[0]);
            Integer b = Integer.parseInt(input[1]);

            gcd = getGCD(a, b);
            lcm = (a * b) / gcd;

            sb.append(lcm + "\n");
        }
        br.close();

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }

    // 유클리드 호제법 반복
    static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}