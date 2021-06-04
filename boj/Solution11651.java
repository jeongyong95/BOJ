package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/*  좌표 정렬하기 2
    2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, 
    y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
    첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
    둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
    (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
    첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 */
public class Solution11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[n][2];
        String[] line;

        for (int i = 0; i < arr.length; i++) {
            line = bufferedReader.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }
        bufferedReader.close();

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            bufferedWriter.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}