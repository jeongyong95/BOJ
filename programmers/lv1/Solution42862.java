package programmers.lv1;

public class Solution42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] nArr = new int[n];

        for (int i : lost) {
            nArr[i - 1]--;
        }

        for (int i : reserve) {
            nArr[i - 1]++;
        }

        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] < 0) {
                if (i != 0 && nArr[i - 1] > 0) {
                    nArr[i]++;
                    nArr[i - 1]--;
                } else if (i != n - 1 && nArr[i + 1] > 0) {
                    nArr[i]++;
                    nArr[i + 1]--;
                }
            }
        }
        for (int i : nArr) {
            if (i >= 0) {
                answer++;
            }
        }
        return answer;
    }
}
