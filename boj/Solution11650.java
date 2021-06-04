package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*  좌표 정렬하기
    2차원 평면 위의 점 N개가 주어진다.
    좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 
    정렬한 다음 출력하는 프로그램을 작성하시오.
    첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
    둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
    (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
    첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 */
public class Solution11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        Location[] locations = new Location[n];
        String[] line = new String[2];

        for (int i = 0; i < locations.length; i++) {
            line = bufferedReader.readLine().split(" ");
            locations[i] = new Location(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        bufferedReader.close();
        Arrays.sort(locations);

        for (int i = 0; i < locations.length; i++) {
            bufferedWriter.write(locations[i].x + " " + locations[i].y + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static class Location implements Comparable<Location> {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location location) {
            if (this.x > location.x) {
                return 1;
            }
            if (this.x == location.x) {
                if (this.y > location.y) {
                    return 1;
                }
                if (this.y == location.y) {
                    return 0;
                }
            }
            return -1;
        }
    }

    static void swap(Location[] arr, int a, int b) {
        Location temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}