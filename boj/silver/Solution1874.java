package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        int flag = 0;
        stack.push(0);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        bufferedReader.close();

        // peek = m일때 m>arr[i]는 성립 불가 m을 작게하려면 결국 pop을 해야하는데 그러면 수열이 달리지기 때문
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                if (stack.peek() > arr[i]) {
                    System.out.println("NO");
                    return;
                }
                if (stack.peek() < arr[i]) {
                    while (true) {
                        stack.push(++flag);
                        sb.append("+\n");
                        if (stack.peek() == arr[i]) {
                            break;
                        }
                    }
                }
                if (stack.peek() == arr[i]) {
                    stack.pop();
                    sb.append("-\n");
                }
                break;
            }
        }
        System.out.println(sb);
    }
}