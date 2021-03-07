package programmers.lv1;

public class Solution12932 {
    public int[] solution(long n) {
        String number = String.valueOf(n);
        String[] arr = number.split("");

        int[] answer = new int[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(arr[answer.length - 1 - i]);
        }

        return answer;
    }
}
