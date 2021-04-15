import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution20040 {
    static int[] link;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        link = new int[n];

        for (int i = 0; i < n; i++) {
            link[i] = i;
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) != find(b)) {
                union(a, b);
            } else {
                answer = i;
                break;
            }
        }
        br.close();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            link[b] = a;
        } else if (a > b) {
            link[a] = b;
        }
    }

    static int find(int x) {
        // 경로 압축
        if (x == link[x]) {
            return x;
        }
        return link[x] = find(link[x]);
    }
}
