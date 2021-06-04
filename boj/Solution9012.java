package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            Stack<Character> stack = new Stack<>();
            char[] arr = bufferedReader.readLine().toCharArray();
            for (char c : arr) {
                if (c == '(') {
                    stack.push(c);
                }
                if (c == ')') {
                    if (stack.isEmpty()) {
                        stack.push(')');
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                sb.append("NO" + '\n');
            }
            if (stack.isEmpty()) {
                sb.append("YES" + '\n');
            }
        }
        bufferedReader.close();

        System.out.println(sb);
    }
}