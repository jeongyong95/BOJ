import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution6064 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int m = arr[0];
            int n = arr[1];
            int x = arr[2];
            int y = arr[3];

            int year = 0;
            int tempX = 0;
            int tempY = 0;
            while (true) {
                year++;
                tempX++;
                tempY++;

                if (tempX == x && tempY == y) {
                    bw.write(year + "\n");
                    break;
                }
                if (tempX == m && tempY == n) {
                    bw.write(-1 + "\n");
                    break;
                }
                if (tempX == m) {
                    tempX = 1;
                }

                if (tempY == n) {
                    tempY = 1;
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}