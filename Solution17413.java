import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        br.close();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean stringFlag = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '<') {
                stringFlag = false;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(arr[i]);
                continue;
            }
            if (arr[i] == '>') {
                stringFlag = true;
                sb.append(arr[i]);
                continue;
            }

            if (arr[i] == ' ' && stringFlag == true) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(arr[i]);
                continue;
            }

            if (stringFlag == true) {
                stack.push(arr[i]);
            }
            if (stringFlag == false) {
                sb.append(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}