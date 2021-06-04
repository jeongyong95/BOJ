package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution2609_repeat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        br.close();

        Integer a = Integer.parseInt(input[0]);
        Integer b = Integer.parseInt(input[1]);

        // 최대 공약수를 구한다.
        Integer gcd = getGCD(a, b);

        // ab = gcd * lcm 으로 lcm을 구한다.
        Integer lcm = (a * b) / gcd;

        bw.write(gcd + "\n" + lcm + "\n");
        bw.flush();
        bw.close();
    }

    // 반복문으로 유클리드 호제법 구현
    static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}