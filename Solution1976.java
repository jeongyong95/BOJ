import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1976 {
    static int[] link;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        link = new int[n + 1];
        int[] target = new int[m];
        for (int i = 1; i < link.length; i++) {
            link[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int connect = Integer.parseInt(st.nextToken());
                if (connect == 1) {
                    unite(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        String answer = "YES";
        for (int i = 0; i < target.length; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < target.length - 1; i++) {
            if (!isSame(target[i], target[i + 1])) {
                answer = "NO";
                break;
            }
        }
        br.close();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void unite(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            link[a] = b;
        } else if (a < b) {
            link[b] = a;
        }
    }

    static int find(int x) {
        // 경로 압축
        if (x == link[x]) {
            return x;
        }
        return link[x] = find(link[x]);
    }

    static boolean isSame(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}