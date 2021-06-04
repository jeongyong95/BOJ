package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution5598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0, size = word.length(); i < size; i++) {
            char newChar = (char) (word.charAt(i) - 3);
            if (newChar < 'A') {
                newChar = (char) (newChar + 26);
            }
            sb.append(newChar);
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
    }
}