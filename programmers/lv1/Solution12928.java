package programmers.lv1;

public class Solution12928 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n; i++) {
            int number = 0;
            if (n % i == 0) {
                number = n / i;
                if (i * i == n) {
                    answer += i;
                    continue;
                }
                answer += number + i;
            }
        }
        return answer;
    }
}
