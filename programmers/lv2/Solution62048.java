package programmers.lv2;

public class Solution62048 {
    // 틀렸당. 공약수 이용하는 문제, 스스로 생각해서 풀어보기
    public long solution(int w, int h) {
        long answer = 1;
        if (w == h) {
            answer = w * h - h;
        } else if (w == 1 || h == 1) {
            return 0;
        } else {
            answer = w > h ? w * h - 2 * h : w * h - 2 * w;
        }
        return answer;
    }
}
