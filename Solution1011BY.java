import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1011BY {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            int speed = 1;

            while (true) {
                arr[0] += speed;
                count++;
                if (arr[0] >= arr[1]) {
                    break;
                }

                arr[1] -= speed;
                count++;
                if (arr[0] >= arr[1]) {
                    break;
                }
                speed++;
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
