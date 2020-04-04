import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*  듣보잡
    김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 
    듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
    첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
    이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
    이름은 띄어쓰기 없이 영어 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
    듣보잡의 수와 그 명단을 사전순으로 출력한다.
 */
public class Solution1764 {
    // Collection, List, toArray, BinarySearch 공부하자. 답지봤으니까 다시 풀어야 하고, HashSet으로
    // 다시풀자
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]), m = Integer.parseInt(numbers[1]);
        String temp = "";
        List<String> noListenList = new ArrayList<String>();
        List<String> resultList = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            noListenList.add(bufferedReader.readLine());
        }
        Collections.sort(noListenList);
        String[] noListenStrings = new String[noListenList.size()];
        noListenStrings = noListenList.toArray(noListenStrings);

        for (int i = 0; i < m; i++) {
            temp = bufferedReader.readLine();
            int index = Arrays.binarySearch(noListenStrings, temp);
            if (index > -1) {
                resultList.add(temp);
            }
        }
        bufferedReader.close();
        Collections.sort(resultList);
        bufferedWriter.write(resultList.size() + "\n");
        for (int i = 0; i < resultList.size(); i++) {
            bufferedWriter.write(resultList.get(i) + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}