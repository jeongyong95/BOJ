import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution14501 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (i >= j + arr[j][0]) {
                    d[i] = Math.max(d[i], arr[i][1] + d[j]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < d.length; i++) {
            if (i + arr[i][0] <= n + 1 && answer < d[i]) {
                answer = d[i];
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}