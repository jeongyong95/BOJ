package programmers.lv2;

import java.util.Arrays;

public class Solution42747 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int hIndex = citations.length - i;
            if (hIndex <= citations[i]) {
                return hIndex;
            }
        }
        return answer;
    }
}
