package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// TODO : ...?
public class Solution17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean[] check = new boolean[n + 1];
            List<Integer> primeNumbers = new ArrayList<>();
            int pcnt = 0;
            check[0] = true;
            check[1] = true;

            for (int i = 2; i * i <= n; i++) {
                if (check[i] == false) {
                    primeNumbers.add(i);
                    for (int j = i + i; j <= n; j += i) {
                        check[j] = true;
                    }
                }
            }

            for (int i = 0; i < primeNumbers.size(); i++) {
                int prime = primeNumbers.get(i);

                if (check[n - prime] = false) {
                    pcnt++;
                }
            }
            sb.append(pcnt + "\n");
        }
        br.close();

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}