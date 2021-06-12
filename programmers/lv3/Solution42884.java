package programmers.lv3;

import java.util.Arrays;
import java.util.Comparator;

public class Solution42884 {
    public int solution(int[][] routes) {
        int answer = 0;
        boolean[] checked = new boolean[routes.length];

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 1. 가장 먼저 나가는 차량의 시간 확인, 차량 확인 처리
        for (int i = 0; i < routes.length; i++) {
            if (checked[i]) {
                continue;
            }
            int setupPoint = routes[i][1];
            checked[i] = true;

            // 2. 해당 시간이 범위에 포함된 차량은 확인한 것으로 처리
            for (int j = i + 1; j < routes.length; j++) {
                if (routes[j][0] <= setupPoint && routes[j][1] >= setupPoint) {
                    checked[j] = true;
                }
            }
            answer++;
        }
        return answer;
    }
}