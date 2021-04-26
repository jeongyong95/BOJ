import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2470 {
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);
        int[] answer = twoPointer();
        bw.write(answer[0] + " " + answer[1] + "\n");
        bw.flush();
        bw.close();
    }

    static int[] twoPointer() {
        // 특성값은 모두 다르다.
        // 0: 용액1, 1: 용액2, 2: 거리
        int[] answer = new int[3];
        answer[2] = Integer.MAX_VALUE;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int dist = Math.abs(sum);

            if (dist < answer[2]) {
                answer[2] = dist;
                answer[0] = arr[left];
                answer[1] = arr[right];
                if (dist == 0) {
                    break;
                }
            }
            if (sum <= 0) {
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}
