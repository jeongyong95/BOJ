package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  최소, 최대
    N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
    첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
    둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
    모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
    첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
 */
public class Solution10818 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, min, max;
        int[] array;
        String[] line;

        n = Integer.parseInt(bufferedReader.readLine());

        array = new int[n];
        line = bufferedReader.readLine().split(" ");

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(line[i]);
        }
        bufferedReader.close();

        min = array[0];
        max = array[0];

        for (int j = 1; j < array.length; j++) {
            if (min > array[j]) {
                min = array[j];
            }
            if (max < array[j]) {
                max = array[j];
            }
        }
        bufferedWriter.write(min + " " + max + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}