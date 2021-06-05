package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// TODO : 풀어야 함
public class Solution14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        br.close();

        input = input.replaceAll("[^(pi)|^(ka)|^(chu)]", "*");
        if (input.matches("[*]")) {
            bw.write("NO\n");
        } else {
            bw.write("YES\n");
        }
        bw.flush();
        bw.close();
    }
}
