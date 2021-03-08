package programmers.lv1;

public class Solution67256 {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        solution(numbers, "right");
    }

    // x,y 좌표를 각 번호에 저장한다.
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[][] numberLocation = { { 1, 0 }, { 0, 3 }, { 1, 3 }, { 2, 3 }, { 0, 2 }, { 1, 2 }, { 2, 2 }, { 0, 1 },
                { 1, 1 }, { 2, 1 } };

        int[] right = { 2, 0 };
        int[] left = { 0, 0 };

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                left = numberLocation[numbers[i]];
                sb.append("L");
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                right = numberLocation[numbers[i]];
                sb.append("R");
            } else {
                int distanceFromLeft = Math.abs(left[0] - numberLocation[numbers[i]][0])
                        + Math.abs(left[1] - numberLocation[numbers[i]][1]);
                int distanceFromRight = Math.abs(right[0] - numberLocation[numbers[i]][0])
                        + Math.abs(right[1] - numberLocation[numbers[i]][1]);
                if (distanceFromLeft > distanceFromRight) {
                    right = numberLocation[numbers[i]];
                    sb.append("R");
                } else if (distanceFromLeft < distanceFromRight) {
                    left = numberLocation[numbers[i]];
                    sb.append("L");
                } else {
                    if (hand.equals("right")) {
                        right = numberLocation[numbers[i]];
                        sb.append("R");
                    } else {
                        left = numberLocation[numbers[i]];
                        sb.append("L");
                    }
                }
            }
        }
        return sb.toString();
    }
}
