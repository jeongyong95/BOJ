package programmers.lv2;

public class Solution42883 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] numArr = number.toCharArray();
        // len-k개를 선택하는 경우임
        int remain = numArr.length - k;

        // i번째 수를 선택하는 경우는 남은 len-남은 k까지
        int current = 0;
        while (remain-- > 0) {
            int range = numArr.length - remain;
            int selectedIndex = current;
            char max = numArr[current];
            for (int i = current + 1; i < range; i++) {
                if (max < numArr[i]) {
                    max = numArr[i];
                    selectedIndex = i;
                }
            }
            sb.append(max);
            current = selectedIndex + 1;
        }
        return sb.toString();
    }
}
