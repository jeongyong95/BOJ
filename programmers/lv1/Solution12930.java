package programmers.lv1;

public class Solution12930 {
    public static void main(String[] args) {
        solution("try hello world");
    }

    public static String solution(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                int acc = 0;
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] == ' ') {
                        break;
                    }
                    if ((j - i) % 2 == 0) {
                        arr[j] = Character.toUpperCase(arr[j]);
                    } else {
                        arr[j] = Character.toLowerCase(arr[j]);
                    }
                    acc++;
                }
                i += acc;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
