package programmers.lv2;

public class Solution43165 {
    static int[] result;
    static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = { 1, 1, 1, 1 };
        int target = 3;
        solution(numbers, target);
    }

    public static int solution(int[] numbers, int target) {

        result = new int[numbers.length];
        dfs(numbers, target, 0);
        return answer;
    }

    static void dfs(int[] arr, int target, int index) {
        if (index == result.length) {
            if (result[index - 1] == target) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                result[index] += arr[index];
                dfs(arr, target, index + 1);
            } else {
                result[index] -= arr[index];
                dfs(arr, target, index + 1);
            }
        }
    }
}