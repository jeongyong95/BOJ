package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  방 번호
    다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
    다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다.
    한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
    다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오.
    (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
    첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.
    첫째 줄에 필요한 세트의 개수를 출력한다.
 */
public class Solution1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int numSet = 0;
        int[] counter = new int[10];
        String[] numString = bufferedReader.readLine().split("");
        bufferedReader.close();

        for (int i = 0; i < numString.length; i++) {
            counter[Integer.parseInt(numString[i])]++;
        }

        counter[6] += counter[9];
        if (counter[6] % 2 != 0) {
            counter[6]++;
        }
        counter[6] /= 2;

        for (int i = 0; i < 9; i++) {
            if (numSet < counter[i]) {
                numSet = counter[i];
            }
        }

        bufferedWriter.write(numSet + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}