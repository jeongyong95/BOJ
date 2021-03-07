package programmers.lv1;

public class Solution12922 {
    public String solution(int n) {
        String answer = "수박";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= n / 2; i++) {
            sb.append(answer);
        }
        answer = sb.substring(0, n);
        return answer;
    }
}
