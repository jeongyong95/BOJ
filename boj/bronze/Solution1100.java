package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  하얀 칸
    체스판은 8*8크기이고, 검정 칸과 하얀 칸이 번갈아가면서 색칠되어 있다. 가장 왼쪽 위칸 (0,0)은 하얀색이다.
    체스판의 상태가 주어졌을 때, 하얀 칸 위에 말이 몇 개 있는지 출력하는 프로그램을 작성하시오.
    첫째 줄부터 8개의 줄에 체스판의 상태가 주어진다. ‘.’은 빈 칸이고, ‘F’는 위에 말이 있는 칸이다.
    첫째 줄에 문제의 정답을 출력한다.
 */
public class Solution1100 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] chess = new String[8];
        int counter = 0;

        for (int i = 0; i < 8; i++) {
            chess[i] = bufferedReader.readLine();
        }
        bufferedReader.close();

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length(); j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0 && chess[i].charAt(j) == 'F') {
                        counter++;
                    }
                }

                if (i % 2 != 0) {
                    if (j % 2 != 0 && chess[i].charAt(j) == 'F') {
                        counter++;
                    }
                }
            }
        }

        bufferedWriter.write(counter + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}