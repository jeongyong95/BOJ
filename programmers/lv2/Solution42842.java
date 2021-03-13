package programmers.lv2;

public class Solution42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for (int i = 1; i * i <= yellow; i++) {
            int height = i;
            if (yellow % height == 0) {
                int width = yellow / height;
                int prediction = height * 2 + width * 2 + 4;
                if (prediction == brown) {
                    answer = new int[2];
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    return answer;
                }
            }
        }
        return answer;
    }
}
