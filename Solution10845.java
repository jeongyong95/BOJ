import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Solution10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();

        while (n-- > 0) {
            String inst = bufferedReader.readLine();

            if (inst.contains("push")) {
                queue.addLast(Integer.parseInt(inst.split(" ")[1]));
            }
            if (inst.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(queue.poll() + "\n");
            }

            if (inst.equals("size")) {
                sb.append(queue.size() + "\n");
            }

            if (inst.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1\n");
                    continue;
                }
                sb.append("0\n");
            }

            if (inst.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(queue.peek() + "\n");
            }

            if (inst.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(queue.peekLast() + "\n");
            }
        }
        bufferedReader.close();
        System.out.println(sb);
    }
}