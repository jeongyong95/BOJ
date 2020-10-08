import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        Integer m = Integer.parseInt(bufferedReader.readLine());
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            leftStack.push(string.charAt(i));
        }

        while (m-- > 0) {
            String instruction = bufferedReader.readLine();

            if (instruction.equals("L")) {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            }

            if (instruction.equals("D")) {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            }

            if (instruction.equals("B")) {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            }

            if (instruction.contains("P ")) {
                instruction = instruction.replaceFirst("P ", "");
                for (int i = 0; i < instruction.length(); i++) {
                    leftStack.push(instruction.charAt(i));
                }
            }
        }
        bufferedReader.close();

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}