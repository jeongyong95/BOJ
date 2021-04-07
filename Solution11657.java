import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution11657 {
    static Map<Integer, List<int[]>> map = new HashMap<>();
    static int[] distance;
    static boolean timeMachine = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] bc = new int[2];
            bc[0] = b;
            bc[1] = c;
            map.get(a).add(bc);
        }
        br.close();

        bellmanFord();
        if (timeMachine) {
            bw.write(-1 + "\n");
        } else {
            for (int i = 2; i < distance.length; i++) {
                if (distance[i] == 50_000_000) {
                    bw.write("-1\n");
                } else {
                    bw.write(distance[i] + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }

    static void bellmanFord() {
        Arrays.fill(distance, 50_000_000);
        distance[1] = 0;

        for (int i = 1; i < distance.length; i++) {
            List<int[]> currentList = map.get(i);
            for (int j = 0, size = currentList.size(); j < size; j++) {
                int[] current = currentList.get(j);
                if (distance[i] != 5_000_000 && distance[current[0]] > distance[i] + current[1]) {
                    distance[current[0]] = distance[i] + current[1];
                }
            }
        }
        for (int i = 1; i < distance.length; i++) {
            List<int[]> currentList = map.get(i);
            for (int[] js : currentList) {
                if (distance[i] != 5_000_000 && distance[js[0]] > distance[i] + js[1]) {
                    timeMachine = true;
                    break;
                }
            }
        }
    }
}
