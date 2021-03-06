package programmers.lv1;

import java.util.Arrays;

public class Solution42576 {
    public String solution(String[] participant, String[] completion) {
        int i = 0;
        Arrays.sort(participant);
        Arrays.sort(completion);

        while (i < completion.length) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
            i++;
        }
        return participant[participant.length - 1];
    }
}