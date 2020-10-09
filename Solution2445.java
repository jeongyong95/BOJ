import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Integer n = Integer.parseInt(br.readLine());
        br.close();
        Integer rn = 0;

        while (n-- > 0) {
            rn++;
            // rn
            for (int i = 0; i < rn; i++) {
                sb.append('*');
            }
            // 2n-2
            for (int i = 0; i < 2 * n; i++) {
                sb.append(' ');
            }
            // rn
            for (int i = 0; i < rn; i++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        n += 1;

        while (rn-- > 0) {
            n++;
            for (int i = 0; i < rn; i++) {
                sb.append('*');
            }

            for (int i = 0; i < n * 2; i++) {
                sb.append(' ');
            }

            for (int i = 0; i < rn; i++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}