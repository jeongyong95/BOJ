import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*  통계학
    수를 처리하는 것은 통계학에서 상당히 중요한 일이다.
    통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
    산술평균 : N개의 수들의 합을 N으로 나눈 값
    중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    최빈값 : N개의 수들 중 가장 많이 나타나는 값
    범위 : N개의 수들 중 최댓값과 최솟값의 차이
    N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
    그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
    첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
    둘째 줄에는 중앙값을 출력한다.
    셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
    넷째 줄에는 범위를 출력한다.
 */
public class Solution2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int sum = 0, maxNumber = 0;
        int[] arr = new int[n];
        List<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
            sum += arr[i];
        }
        bufferedReader.close();
        Arrays.sort(arr);
        int[] countNumber = new int[(arr[n - 1] + 1) * 2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                countNumber[arr[i] * -2]++;
            }
            countNumber[arr[i]]++;
        }
        for (int i = 0; i < countNumber.length; i++) {
            if (maxNumber < countNumber[i]) {
                maxNumber = countNumber[i];
            }
        }
        for (int i = 0; i < countNumber.length; i++) {
            if (countNumber[i] == maxNumber) {
                arrList.add(i);
            }
        }

        bufferedWriter.write("-------------\n");
        bufferedWriter.write(sum / n + "\n");
        bufferedWriter.write(arr[(n - 1) / 2] + "\n");
        if (arrList.size() > 1) {
            bufferedWriter.write(arrList.get(1).intValue() + "\n");
        }
        if (arrList.size() == 1) {
            bufferedWriter.write(arrList.get(0).intValue() + "\n");
        }
        bufferedWriter.write((arr[n - 1] - arr[0]) + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}