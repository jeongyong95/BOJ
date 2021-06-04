package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solution10953
 */
public class Solution10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(bufferedReader.readLine());
        Integer a, b;
        StringBuilder sb = new StringBuilder();

        while (t > 0) {
            String[] strings = bufferedReader.readLine().split(",");
            a = Integer.parseInt(strings[0]);
            b = Integer.parseInt(strings[1]);
            sb.append(a + b + "\n");
            t--;
        }
        bufferedReader.close();

        System.out.println(sb);
    }
}