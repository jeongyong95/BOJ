import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String document = br.readLine();
        String word = br.readLine();
        br.close();

        int index = 0;
        int temp = 0;
        int count = 0;
        while (true) {
            temp = document.indexOf(word, index);
            if (temp == -1) {
                break;
            }
            index = temp + word.length();
            count++;
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}