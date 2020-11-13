import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int d = 0;
        int gcd = 0;

        input = br.readLine().split(" ");
        int[] brothers = new int[n];

        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = Integer.parseInt(input[i]);
        }
        br.close();

        gcd = Math.abs(brothers[0] - s);
        for (int i = 1; i < brothers.length; i++) {
            d = Math.abs(brothers[i] - s);
            gcd = getGcd(gcd, d);
        }
        bw.write(gcd + "\n");
        bw.flush();
        bw.close();
    }

    static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}