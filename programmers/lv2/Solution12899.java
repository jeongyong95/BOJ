package programmers.lv2;

public class Solution12899 {
    public String solution(int n) {
        String[] numbers = { "4", "1", "2" };
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int index = n % 3;
            sb.append(numbers[index]);
            if (index == 0) {
                n /= 3;
                n--;
            } else {
                n /= 3;
            }
        }
        return sb.reverse().toString();
    }
}
