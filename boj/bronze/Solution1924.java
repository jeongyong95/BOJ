package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] month12 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] weekString = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        String[] temp = br.readLine().split(" ");
        br.close();

        int m = Integer.parseInt(temp[0]);
        int d = Integer.parseInt(temp[1]);
        int target = 0;

        for (int i = 0; i < m - 1; i++) {
            target += month12[i];
        }
        target += d;

        System.out.println(weekString[target % 7]);
    }
}