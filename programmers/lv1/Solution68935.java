package programmers.lv1;

public class Solution68935 {
    public int solution(int n) {
        int answer = 0;
        StringBuilder temp3 = new StringBuilder();
        while (n > 0) {
            temp3.append(n % 3);
            n /= 3;
        }
        int k = 1;
        String[] temp = temp3.toString().split("");
        for (int i = temp.length - 1; i >= 0; i--) {
            if (!temp[i].equals("0")) {
                answer += Integer.parseInt(temp[i]) * k;
            }
            k *= 3;
        }
        return answer;
    }
}
