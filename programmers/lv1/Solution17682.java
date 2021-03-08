package programmers.lv1;

public class Solution17682 {
    public static void main(String[] args) {
        solution("1S2D*3T");
    }

    public static int solution(String dartResult) {
        int answer = 0;
        int seq = 0;
        int[] score = new int[3];
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < dartResult.length(); i++) {
            char target = dartResult.charAt(i);
            if (target >= '0' && target <= '9') {
                temp.append(target);
            } else if (target >= 'D' && target <= 'T') {
                score[seq++] = Integer.parseInt(temp.toString());
                temp = new StringBuilder();
                if (target == 'D') {
                    score[seq - 1] = score[seq - 1] * score[seq - 1];
                }
                if (target == 'T') {
                    score[seq - 1] = score[seq - 1] * score[seq - 1] * score[seq - 1];
                }
            } else if (target == '*') {
                if (seq == 1) {
                    score[0] *= 2;
                } else {
                    score[seq - 1] *= 2;
                    score[seq - 2] *= 2;
                }
            } else if (target == '#') {
                score[seq - 1] *= -1;
            }
        }

        for (int i = 0; i < score.length; i++) {
            answer += score[i];
        }
        return answer;
    }
}
