package programmers.lv1;

public class Solution12901 {
    public String solution(int a, int b) {
        String answer = "";
        String[] dayStrings = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
        int[] DaysOfYear = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int days = 0;
        for (int i = 0; i < a; i++) {
            days += DaysOfYear[i];
        }
        days += b;
        answer = dayStrings[days % 7];
        return answer;
    }
}
