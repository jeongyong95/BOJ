package programmers.lv1;

public class Solution12943 {
    public int solution(int num) {
        int answer = 0;
        long number = num;
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number *= 3;
                number++;
            }
            answer++;
            if (answer == 500) {
                return -1;
            }
        }
        return answer;
    }
}
