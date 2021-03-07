package programmers.lv1;

public class Solution12947 {
    public boolean solution(int x) {
        boolean answer = true;
        int divider = 0;
        int temp = x;
        while (temp > 0) {
            divider += temp % 10;
            temp /= 10;
        }
        if (x % divider != 0) {
            answer = false;
        }
        return answer;
    }
}
