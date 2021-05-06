package programmers.lv2;

public class Solution43165 {
    static int answer = 0;
    static int goal;
    static int[] arr;

    public int solution(int[] numbers, int target) {
        arr = numbers;
        goal = target;
        dfs(0, 0);
        return answer;
    }

    static void dfs(int index, int sum) {
        if (index == arr.length) {
            if (sum == goal) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                sum += arr[index];
                dfs(index + 1, sum);
                sum -= arr[index];
            } else {
                sum -= arr[index];
                dfs(index + 1, sum);
                sum += arr[index];
            }
        }
    }
}