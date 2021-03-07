package programmers.lv1;

public class Solution12940 {

    // 최대공약수를 구하고 그 후 최소공배수를 구한다.
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int g = 0;
        int l = n * m;
        while (true) {
            if (m == 0) {
                g = n;
                break;
            }
            int temp = m;
            m = n % m;
            n = temp;
        }
        answer[0] = g;
        answer[1] = l / g;
        return answer;
    }
}
