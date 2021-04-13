import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1966 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        Queue<Document> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] prioritySlot = new int[10];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.offer(new Document(i, priority));
                prioritySlot[priority]++;
            }

            while (!q.isEmpty()) {
                boolean possible = true;
                Document current = q.peek();
                for (int i = current.priority + 1; i < 10; i++) {
                    if (prioritySlot[i] > 0) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    q.poll();
                    if (current.number == m) {
                        sb.append(n - q.size() + "\n");
                    }
                    prioritySlot[current.priority]--;
                } else {
                    q.offer(q.poll());
                }
            }
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

class Document {
    int number;
    int priority;

    public Document(int number, int priority) {
        this.number = number;
        this.priority = priority;
    }
}
