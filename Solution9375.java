import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution9375 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> clothes = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kinds = st.nextToken();
                clothes.put(kinds, clothes.getOrDefault(kinds, 0) + 1);
            }
            int answer = 1;
            for (Integer i : clothes.values()) {
                answer *= i + 1;
            }
            answer--;
            sb.append(answer + "\n");
            clothes.clear();
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}