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

public class Solution1068 {
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int deletedTarget = Integer.parseInt(br.readLine());
        br.close();

        for (int i = -1; i < n; i++) {
            tree.put(i, new ArrayList<>());
        }
        for (int i = 0, size = st.countTokens(); i < size; i++) {
            tree.get(Integer.parseInt(st.nextToken())).add(i);
        }
        visited = new boolean[n];

        dfs(-1, deletedTarget);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int start, int deletedTarget) {
        List<Integer> adjList = tree.get(start);
        if (adjList.contains(deletedTarget)) {
            Integer target = deletedTarget;
            adjList.remove(target);
        }

        if (adjList.size() == 0) {
            if (start == -1) {
                return;
            } else {
                answer++;
                return;
            }
        }

        for (Integer i : adjList) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(i, deletedTarget);
            visited[i] = false;
        }
    }
}
