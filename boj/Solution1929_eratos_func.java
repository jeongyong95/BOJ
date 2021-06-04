package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1929_eratos_func {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        Integer a = Integer.parseInt(input[0]);
        Integer b = Integer.parseInt(input[1]);
        br.close();

        boolean[] result = isPrimeNumber(b);

        for (int i = a; i < result.length; i++) {
            if (result[i] == false) {
                sb.append(i + "\n");
            }
        }
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }

    static boolean[] isPrimeNumber(int b) {
        boolean[] check = new boolean[b + 1];
        check[1] = true;

        for (int i = 2; i * i <= b; i++) {
            if (check[i] == false) {
                for (int j = i + i; j <= b; j += i) {
                    check[j] = true;
                }
            }
        }
        return check;
    }
}