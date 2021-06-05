package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            char[] arr = br.readLine().toCharArray();
            boolean palindromeFlag = true;

            if (arr.length == 1 && arr[0] == '0') {
                br.close();
                break;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != arr[arr.length - 1 - i]) {
                    palindromeFlag = false;
                    break;
                }
            }

            if (palindromeFlag) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
