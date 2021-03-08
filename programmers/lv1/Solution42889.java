package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution42889 {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 1; i <= N + 1; i++) {
            int count = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    count++;
                }
            }
            list.add(count);
        }

        return 0;
    }
}
