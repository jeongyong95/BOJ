import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// TODO : 시간초과
public class Solution7662 {
    static String D = "D";
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int operations = Integer.parseInt(br.readLine());
            while (operations-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int element = Integer.parseInt(st.nextToken());

                if (operation.equals(D)) {
                    if (pq.isEmpty()) {
                        continue;
                    } else if (element == 1) {
                        int target = reversePq.poll();
                        pq.remove(target);
                    } else {
                        int target = pq.poll();
                        reversePq.remove(target);
                    }
                } else {
                    pq.offer(element);
                    reversePq.offer(element);
                }
            }

            if (pq.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(reversePq.peek() + " " + pq.peek() + "\n");
                pq.clear();
                reversePq.clear();
            }
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}