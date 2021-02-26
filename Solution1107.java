import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1107 {
    static boolean[] isBrokenNumber = new boolean[10];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] brokenNumberArr = new int[0];
        if (m > 0) {
            brokenNumberArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        int answer = n - 100;
        if (n < 100) {
            answer = -answer;
        }

        for (int i = 0; i < brokenNumberArr.length; i++) {
            isBrokenNumber[brokenNumberArr[i]] = true;
        }

        for (int i = 0; i <= 1000000; i++) {
            int number = i;
            int length = possible(number);

            if (length > 0) {
                int push = Math.abs(number - n);

                if (answer > length + push) {
                    answer = length + push;
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static int possible(int number) {
        if (number == 0) {
            if (isBrokenNumber[0]) {
                return 0;
            }
            return 1;
        }

        int length = 0;
        while (number > 0) {
            if (isBrokenNumber[number % 10]) {
                return 0;
            }
            length++;
            number /= 10;
        }
        return length;
    }
}
