import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        String[] numberString = br.readLine().split(" ");
        br.close();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(numberString[i]);
        }
        stack.push(0);

        for (int i = 1; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i] + " ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}