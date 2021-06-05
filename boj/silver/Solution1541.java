package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("\\-");
        br.close();

        int answer = 0;
        String[] first = input[0].split("\\+");
        for (String string : first) {
            answer += Integer.parseInt(string);
        }
        for (int i = 1; i < input.length; i++) {
            String[] elements = input[i].split("\\+");
            int temp = 0;
            for (String string : elements) {
                temp += Integer.parseInt(string);
            }
            answer -= temp;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}