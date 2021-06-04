package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2667 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][];
        for (int i = 0; i < map.length; i++) {
            int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            map[i] = arr;
        }
        br.close();

        List<Integer> answer = bfs(map);
        Collections.sort(answer);

        bw.write(answer.size() + "\n");
        for (int i = 0, size = answer.size(); i < size; i++) {
            bw.write(answer.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static List<Integer> bfs(int[][] map) {
        List<Integer> answer = new ArrayList<>();
        int[] direct = { -1, 1 };
        // 사방으로 1인 요소를 큐에 넣는다.
        // 큐에서 값을 제거하며 단지의 집 수를 계산한다.
        // 단지 수 : 리스트의 사이즈, 단지 당 집 수 : 리스트 원소
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    int element = 0;
                    int[] current = { i, j };
                    q.offer(current);
                    map[i][j] = 0;
                    while (!q.isEmpty()) {
                        int[] target = q.poll();
                        element++;
                        for (int k = 0; k < direct.length; k++) {
                            if (target[0] + direct[k] >= 0 && target[0] + direct[k] < map.length
                                    && map[target[0] + direct[k]][target[1]] == 1) {
                                int[] temp = { target[0] + direct[k], target[1] };
                                q.offer(temp);
                                map[target[0] + direct[k]][target[1]] = 0;
                            }
                            if (target[1] + direct[k] >= 0 && target[1] + direct[k] < map[target[0]].length
                                    && map[target[0]][target[1] + direct[k]] == 1) {
                                int[] temp = { target[0], target[1] + direct[k] };
                                q.offer(temp);
                                map[target[0]][target[1] + direct[k]] = 0;
                            }
                        }
                    }
                    answer.add(element);
                }
            }
        }
        return answer;
    }
}