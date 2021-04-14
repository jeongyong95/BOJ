import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution5021 {
    static Map<String, List<String>> tree = new HashMap<>();
    static Map<String, Double> priority = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        String root = br.readLine();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String p1 = st.nextToken();
            String p2 = st.nextToken();

            tree.put(child, new ArrayList<>());
            tree.get(child).add(p1);
            tree.get(child).add(p2);
        }
        priority.put(root, 1.0);

        String answer = "";
        double temp = 0.0;
        while (m-- > 0) {
            String candidate = br.readLine();
            double candidateValue = dfs(candidate);
            if (temp < candidateValue) {
                answer = candidate;
                temp = candidateValue;
            }
        }
        br.close();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static double dfs(String child) {
        if (priority.containsKey(child)) {
            return priority.get(child);
        }

        if (!tree.containsKey(child)) {
            return 0;
        }

        double temp = 0.0;
        for (String s : tree.get(child)) {
            temp += dfs(s) / 2;
        }
        priority.put(child, temp);
        return temp;
    }
}