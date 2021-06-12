package programmers.lv2;

import java.util.Arrays;

public class Solution42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int boat = people[right--];
            if (boat + people[left] <= limit) {
                left++;
            }
            answer++;
        }
        return answer;
    }
}
