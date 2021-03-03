import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution14888 {

    static int[] arr;
    static int[] calArr;
    static long max = -1000000000;
    static long min = 1000000000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 각각 연산횟수 : + - * /
        calArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        go(0, n, arr[0]);

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    static void go(int index, int n, long result) {
        if (index == n - 1) {
            if (max < result) {
                max = result;
            }
            if (min > result) {
                min = result;
            }
            return;
        }

        for (int i = 0; i < calArr.length; i++) {
            if (calArr[i] != 0) {
                long temp = calculate(i, result, arr[index + 1]);
                calArr[i]--;
                go(index + 1, n, temp);
                calArr[i]++;
            }
        }
    }

    static long calculate(int type, long a, long b) {
        long result = 0;
        switch (type) {
            case 0:
                result = a + b;
                break;
            case 1:
                result = a - b;
                break;
            case 2:
                result = a * b;
                break;

            default:
                result = a / b;
                break;
        }

        return result;
    }
}
