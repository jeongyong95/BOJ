package programmers.lv1;

public class Solution12926 {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }

            if (arr[i] < 'a') {
                arr[i] += n;
                if (arr[i] >= 'a') {
                    arr[i] = (char) (arr[i] - 'Z' + 64);
                }
            } else {
                arr[i] += n;
                if (arr[i] > 'z') {
                    arr[i] = (char) (arr[i] - 'z' + 96);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
