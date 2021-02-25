import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1011 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            int speed = 1;
            int distance = arr[1] - arr[0];

            while (distance > 0) {
                if (distance < speed) {
                    speed--;
                    count++;
                    break;
                }

                if (distance == speed) {
                    count++;
                    break;
                }
                distance -= 2 * speed;
                count += 2;
                speed++;
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
