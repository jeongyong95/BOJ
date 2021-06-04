package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution11723 {
    static int s = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken()) - 1;
            }
            doIt(operation, num);
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void doIt(String operation, int num) {
        switch (operation) {
            case "add":
                s |= 1 << num;
                break;
            case "remove":
                s = s & ~(1 << num);
                break;
            case "check":
                int isExist = s & (1 << num);
                if (isExist != 0) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
                break;
            case "toggle":
                s ^= 1 << num;
                break;
            case "all":
                s |= ~0;
                break;

            default:
                s = 0;
                break;
        }
    }
}
