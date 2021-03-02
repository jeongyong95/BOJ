import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1059 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(arr);
        boolean[] checkArr = new boolean[1001];
        for (int i = 0; i < arr.length; i++) {
            checkArr[arr[i]] = true;
        }

        if (checkArr[n]) {
            bw.write("0" + "\n");
            bw.flush();
            bw.close();
            return;
        }

        int increase = 0;
        int decrease = 0;

        for (int i = n + 1; i <= arr[l - 1]; i++) {
            if (checkArr[i]) {
                break;
            }
            increase++;
        }

        for (int i = n - 1; i >= 1; i--) {
            if (checkArr[i]) {
                break;
            }
            decrease++;
        }

        bw.write(increase * decrease + increase + decrease + "\n");
        bw.flush();
        bw.close();
    }
}
