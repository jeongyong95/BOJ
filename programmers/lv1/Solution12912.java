package programmers.lv1;

public class Solution12912 {
    public long solution(int a, int b) {
        long answer = 0;
        if (a == b) {
            return a;
        } else {
            int small = a < b ? a : b;
            int big = a + b - small;

            for (int i = small; i <= big; i++) {
                answer += i;
            }
        }
        return answer;
    }
}
