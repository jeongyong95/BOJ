package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int[] numbers = new int[n];
            long gcdSum = 0;

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(input[i + 1]);
            }

            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    int a = numbers[i];
                    int b = numbers[j];
                    gcdSum += getGcd(a, b);
                }
            }
            sb.append(gcdSum + "\n");
        }
        br.close();
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }

    static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}