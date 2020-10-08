import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Solution1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        br.close();

        Integer n = Integer.parseInt(NK[0]);
        Integer k = Integer.parseInt(NK[1]);
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder("<");

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {

            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }

            if (queue.size() == 1) {
                sb.append(queue.poll() + ">");
                continue;
            }

            sb.append(queue.poll() + ", ");
        }

        System.out.println(sb);
    }
}