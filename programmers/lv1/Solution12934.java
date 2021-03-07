package programmers.lv1;

public class Solution12934 {
    public long solution(long n) {
        long answer = 0;
        long target = (long) Math.sqrt(n);
        if (target * target == n) {
            return answer = (long) Math.pow(target + 1, 2);
        }
        return -1;
    }
}
