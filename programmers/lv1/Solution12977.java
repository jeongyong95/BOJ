package programmers.lv1;

import java.util.Arrays;

public class Solution12977 {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int max = nums[nums.length - 1] * 3 - 3;
        boolean[] primeNumber = new boolean[max + 1];
        Arrays.fill(primeNumber, true);

        for (int i = 2; i * i < primeNumber.length; i++) {
            for (int j = i + i; j < primeNumber.length; j += i) {
                if (primeNumber[j]) {
                    primeNumber[j] = false;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (primeNumber[nums[i] + nums[j] + nums[k]]) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}