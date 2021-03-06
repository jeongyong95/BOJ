package programmers.lv1;

public class Solution12912Re {
    public long solution(int a, int b) {
        long answer = 0;
        if (a == b) {
            return a;
        } else {
            int small = a < b ? a : b;
            int big = a + b - small;

            answer = (long) (((big + small) / 2.0) * (big - small + 1));
        }
        return answer;
    }
}
