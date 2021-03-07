package programmers.lv1;

import java.util.Arrays;

public class Solution12921 {
    public int solution(int n) {
        int answer = 0;
        boolean[] primeNumbers = new boolean[n + 1];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = primeNumbers[1] = false;

        for (int i = 2; i * i < n; i++) {
            for (int j = i * 2; j < primeNumbers.length; j += i) {
                primeNumbers[j] = false;
            }
        }

        for (int i = 2; i < primeNumbers.length; i++) {
            if (primeNumbers[i]) {
                answer++;
            }
        }
        return answer;
    }
}
