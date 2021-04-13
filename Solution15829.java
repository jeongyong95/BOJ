import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution15829 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long r = 1;
        long mod = 1234567891;
        int len = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        br.close();

        long answer = 0;
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            answer += (c - 96) * r % mod;
            r %= mod;
            r *= 31;
        }
        answer %= mod;
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}