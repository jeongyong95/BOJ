import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Integer n = Integer.parseInt(br.readLine());
        br.close();
        Integer rn = 0;

        while (n > 0) {
            n--;
            for (int i = 0; i < n; i++) {
                sb.append(' ');
            }

            rn++;
            for (int i = 0; i < rn * 2 - 1; i++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        while (rn > 0) {
            n++;
            for (int i = 0; i < n; i++) {
                sb.append(' ');
            }

            rn--;
            for (int i = 0; i < rn * 2 - 1; i++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}