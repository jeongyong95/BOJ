import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// TODO : 다이나믹 프로그래밍으로 접근해야함
public class Solution1010 {
    static int n;
    static int m;
    static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            getCombination(0);
            sb.append(answer + "\n");
            answer = 0;
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void getCombination(int current) {
        if (current == n - 1) {
            answer++;
            return;
        }

        for (int i = current; i < m; i++) {
            getCombination(i + 1);
        }
    }
}
