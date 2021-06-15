package programmers.lv2;

// TODO : 이해 못함. 다시 풀어야 함
public class Solution42860 {
    public int solution(String name) {
        int answer = 0;
        char[] arr = name.toCharArray();

        // 1. 조이스틱 이동 상하 계산
        // M까지는 앞에서 뒤로 이동, 이후로는 뒤에서 앞으로 이동
        for (char c : arr) {
            if (c <= 'M') {
                answer += c - 'A';
            } else {
                answer += 'Z' - c + 1;
            }
        }

        // 2. 조이스틱 이동 좌우 계산
        int minMove = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int next = i + 1;
            while (next < arr.length && arr[next] == 'A') {
                next++;
            }
            minMove = Math.min(minMove, i + arr.length - next + i);
        }
        answer += minMove;

        // 1 + 2가 answer
        return answer;
    }
}