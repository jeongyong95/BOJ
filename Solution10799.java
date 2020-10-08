import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            }
            if (arr[i] == ')') {
                if (i == stack.peek() + 1) {
                    stack.pop();
                    result += stack.size();
                    continue;
                }
                stack.pop();
                result += 1;
            }
        }

        System.out.println(result);
    }
}