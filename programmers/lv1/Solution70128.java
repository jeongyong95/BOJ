package programmers.lv1;

public class Solution70128 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < b.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
