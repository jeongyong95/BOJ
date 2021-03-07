package programmers.lv1;

import java.util.Arrays;

public class Solution12933 {
    public long solution(long n) {
        String string = String.valueOf(n);
        String[] arr = string.split("");
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}
