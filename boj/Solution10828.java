package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution10828 {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String instruction = bufferedReader.readLine();
            stackFunction(instruction);
        }
        bufferedReader.close();
    }

    public static void stackFunction(String instruction) {
        String[] instructionStrings = instruction.split(" ");

        switch (instructionStrings[0]) {
            case "push":
                stack.push(Integer.parseInt(instructionStrings[1]));
                break;

            case "pop":
                if (stack.empty()) {
                    System.out.println(-1);
                    break;
                }
                System.out.println(stack.pop());
                break;

            case "size":
                System.out.println(stack.size());
                break;

            case "empty":
                if (stack.empty()) {
                    System.out.println(1);
                    break;
                }
                System.out.println(0);
                break;

            default:
                if (stack.empty()) {
                    System.out.println(-1);
                    break;
                }
                System.out.println(stack.peek());
                break;
        }
    }
}