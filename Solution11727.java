import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (!(i == 0) && i % 10 == 0) {
                sb.append("\n");
            }
            sb.append(input[i]);
        }
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}