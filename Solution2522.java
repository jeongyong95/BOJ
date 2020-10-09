import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        br.close();
        Integer rn = 0;
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            rn++;
            for (int i = 0; i < n; i++) {
                sb.append(' ');
            }
            for (int i = 0; i < rn; i++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        n += 1;

        while (rn-- > 0) {
            n++;
            for (int i = 0; i < n; i++) {
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