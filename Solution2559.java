import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2559 {
    static int n;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        tree = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            update(i, arr[i]);
        }

        int max = -100_000_000;
        for (int i = k; i <= n; i++) {
            int result = sum(i) - sum(i - k);
            if (max < result) {
                max = result;
            }
        }
        br.close();

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    static void update(int index, int diff) {
        while (index <= n) {
            tree[index] += diff;
            index += index & -index;
        }
    }

    static int sum(int endIndex) {
        int result = 0;
        while (endIndex >= 1) {
            result += tree[endIndex];
            endIndex -= endIndex & -endIndex;
        }
        return result;
    }
}
