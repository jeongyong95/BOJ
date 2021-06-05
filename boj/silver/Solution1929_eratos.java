package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1929_eratos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        Integer a = Integer.parseInt(input[0]);
        Integer b = Integer.parseInt(input[1]);
        br.close();

        boolean[] check = new boolean[b + 1];
        check[1] = true;

        for (int i = 2; i * i <= b; i++) {
            if (check[i] == false) {
                for (int j = i + i; j <= b; j += i) {
                    check[j] = true;
                }
            }
        }

        for (int i = a; i < check.length; i++) {
            if (check[i] == false) {
                sb.append(i + "\n");
            }
        }
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }

}