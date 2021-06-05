package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution6588 {

    public static int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        List<Integer> primes = new ArrayList<>();
        boolean[] check = new boolean[MAX + 1];

        check[0] = true;
        check[1] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (check[i] == true) {
                continue;
            }
            primes.add(i);
            for (int j = i + i; j <= MAX; j += i) {
                check[j] = true;
            }
        }

        while (true) {
            Integer n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            boolean flag = false;

            // 소수가 1개면 의미가 어차피 없음
            for (int i = 1; i < primes.size(); i++) {
                int prime = primes.get(i);
                if (prime > n) {
                    break;
                }
                if (check[n - prime] == false) {
                    sb.append(n + " = " + prime + " + " + (n - prime) + "\n");
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }
        br.close();

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }

}