import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  네 번째 점
    세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
    세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
    직사각형의 네 번째 점의 좌표를 출력한다.
 */
public class Solution3009 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] xy = new int[3][2];
        int[] requiredXy = new int[2];
        String[] line = new String[2];

        for (int i = 0; i < 3; i++) {
            line = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                xy[i][j] = Integer.parseInt(line[j]);
            }
        }
        bufferedReader.close();

        for (int i = 0; i < 2; i++) {
            int temp = xy[0][i];
            requiredXy[i] = temp == xy[1][i] ? xy[2][i] : (temp == xy[2][i] ? xy[1][i] : temp);
        }

        bufferedWriter.write(requiredXy[0] + " " + requiredXy[1] + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}