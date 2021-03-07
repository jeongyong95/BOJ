package programmers.lv1;

public class Solution12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long element = x;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = element;
            element += x;
        }
        return answer;
    }
}
