package programmers.lv3;

import java.util.Arrays;
import java.util.Comparator;

public class Solution42861 {
    static int[] link;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        link = new int[n];
        for (int i = 0; i < link.length; i++) {
            link[i] = i;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];

            if (!isSame(a, b)) {
                unite(a, b);
                answer += c;
            }
        }

        return answer;
    }

    static int find(int x) {
        if (x == link[x]) {
            return x;
        }
        return link[x] = find(link[x]);
    }

    static void unite(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            link[Math.max(a, b)] = Math.min(a, b);
        }
    }

    static boolean isSame(int a, int b) {
        return find(a) == find(b);
    }
}