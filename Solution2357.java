import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2357 {
    static int n;
    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        minTree = new int[2 * n + 1];
        maxTree = new int[2 * n + 1];

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            updateMin(i, num);
            updateMax(i, num);
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] answer = getAnswer(a, b);

            sb.append(answer[0]).append(" ").append(answer[1] + "\n");
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void updateMin(int k, int x) {
        k += n;
        minTree[k] += x;
        for (k /= 2; k >= 1; k /= 2) {
            minTree[k] = Math.min(minTree[2 * k], minTree[2 * k + 1]);
        }
    }

    static void updateMax(int k, int x) {
        k += n;
        maxTree[k] += x;
        for (k /= 2; k >= 1; k /= 2) {
            maxTree[k] = Math.min(maxTree[2 * k], maxTree[2 * k + 1]);
        }
    }

    static int[] getAnswer(int a, int b) {
        int[] answer = new int[2];

        while (a <= b) {
            if (a % 2 == 1) {
                answer[0] = minTree[a];
                answer[1] = maxTree[a];
                a++;
            }
            if (b % 2 == 0) {
                answer[0] = minTree[b];
                answer[1] = maxTree[b];
                b--;
            }
            a /= 2;
            b /= 2;
        }
        return answer;
    }
}