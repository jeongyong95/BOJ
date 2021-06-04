package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/*  직각삼각형
    과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다.
    주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
    입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다.
    각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.
    각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
 */
public class Solution4153 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numRepo = new int[3];
        String[] inputStrings = new String[3];
        List<String> resultList = new ArrayList<String>();

        while (true) {
            inputStrings = bufferedReader.readLine().split(" ");
            numRepo[0] = Integer.parseInt(inputStrings[0]);
            numRepo[1] = Integer.parseInt(inputStrings[1]);
            numRepo[2] = Integer.parseInt(inputStrings[2]);

            if (numRepo[0] == 0 && numRepo[1] == 0 && numRepo[2] == 0) {
                break;
            }
            resultList.add(checkVertical(numRepo));
        }
        bufferedReader.close();

        for (String string : resultList) {
            bufferedWriter.write(string + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static String checkVertical(int[] numRepo) {
        int maxNumber = 0;

        maxNumber = numRepo[0];

        if (maxNumber < numRepo[1]) {
            maxNumber = numRepo[1];
        }
        if (maxNumber < numRepo[2]) {
            maxNumber = numRepo[2];
        }

        if (maxNumber * maxNumber * 2 == numRepo[0] * numRepo[0] + numRepo[1] * numRepo[1] + numRepo[2] * numRepo[2]) {
            return "right";
        }
        return "wrong";
    }
}