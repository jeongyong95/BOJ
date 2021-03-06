package programmers.lv1;

import java.util.Arrays;

public class Solution42862 {
    // 틀렸당
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = lost.length - 1; i >= 0; i--) {
            for (int j = reserve.length - 1; j >= 0; j--) {
                if (reserve[j] == lost[i] + 1 || reserve[j] == lost[i] - 1) {
                    reserve[j] = -1;
                    lost[i] = -1;
                    answer++;
                }
            }
        }
        return answer;
    }
}
