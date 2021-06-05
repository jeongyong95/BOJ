package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution14916 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int remain = Integer.parseInt(br.readLine());
        br.close();

        int answer = 0;
        while (true) {
            if (remain % 5 == 0) {
                answer += remain / 5;
                break;
            } else {
                remain -= 2;
                answer++;
                if (remain < 0) {
                    answer = -1;
                    break;
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
