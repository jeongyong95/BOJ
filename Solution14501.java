import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution14501 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] tArr = new int[n];
        int[] pArr = new int[n];

        for (int i = 0; i < pArr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            tArr[i] = Integer.parseInt(st.nextToken());
            pArr[i] = Integer.parseInt(st.nextToken());

        }
    }
}