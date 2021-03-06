package programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution12915 {
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                if (o1.charAt(n) == o2.charAt(n)) {
                    int nextIndex = 0;
                    while (true) {
                        if (o1.charAt(nextIndex) == o2.charAt(nextIndex)) {
                            nextIndex++;
                        } else {
                            return o1.charAt(nextIndex) - o2.charAt(nextIndex);
                        }
                    }
                }
                return o1.charAt(n) - o2.charAt(n);
            }

        });
        return strings;
    }
}
