import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution3053 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(br.readLine());
        br.close();

        sb.append(Math.PI * r * r + "\n").append((double) r * r * 2 + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
