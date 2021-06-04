package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(bufferedReader.readLine());
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String string = bufferedReader.readLine() + '\n';
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == ' ' || string.charAt(j) == '\n') {
                    while (!stack.isEmpty()) {
                        result.append(stack.pop());
                    }
                    result.append(string.charAt(j));
                } else {
                    stack.push(string.charAt(j));
                }
            }
        }
        bufferedReader.close();
        System.out.println(result);
    }
}