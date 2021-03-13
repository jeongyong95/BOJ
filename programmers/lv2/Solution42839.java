package programmers.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution42839 {

    public static int solution(String numbers) {
        int answer = 0;
        String[] keyArr = numbers.split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < keyArr.length; i++) {
            map.put(keyArr[i], map.getOrDefault(keyArr[i], 0) + 1);
        }

        Arrays.sort(keyArr);
        StringBuilder sb = new StringBuilder();
        for (int i = keyArr.length - 1; i >= 0; i--) {
            sb.append(keyArr[i]);
        }
        int max = Integer.valueOf(sb.toString());

        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i < prime.length; i++) {
            for (int j = i + i; j < prime.length; j += i) {
                if (prime[j]) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                String[] targets = String.valueOf(i).split("");
                boolean possible = true;
                int[] checkArr = new int[10];
                for (int j = 0; j < checkArr.length; j++) {
                    checkArr[j] = map.getOrDefault(String.valueOf(j), 0);
                }
                for (int j = 0; j < targets.length; j++) {
                    int target = Integer.valueOf(targets[j]);
                    if (checkArr[target] == 0) {
                        possible = false;
                        break;
                    } else {
                        checkArr[target]--;
                    }
                }
                if (possible) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
