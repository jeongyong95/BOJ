package programmers.lv1;

/**
 * 약수의 개수와 덧셈
 */
public class Solution77884 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (hasEven(i)) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    static boolean hasEven(int number) {
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                return false;
            }
        }
        return true;
    }

}