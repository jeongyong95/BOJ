package boj.graphSearch.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14502 {
    static int answer = 0;
    static int[][] map;
    static int[][] settingMap;
    static int[][] testMap;

    static int[] moveN = { 0, 0, -1, 1 };
    static int[] moveM = { -1, 1, 0, 0 };
    static Queue<Position> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        settingMap = new int[n][m];
        testMap = new int[n][m];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                settingMap[i][j] = map[i][j];
            }
        }
        br.close();

        backTracking(0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    // 벽을 세운다
    static void backTracking(int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            getAnswer();
            return;
        }

        for (int i = 0; i < settingMap.length; i++) {
            for (int j = 0; j < settingMap[i].length; j++) {
                if (settingMap[i][j] == 0) {
                    settingMap[i][j] = 1;
                    backTracking(wallCnt + 1);
                    settingMap[i][j] = 0;
                }
            }
        }
    }

    // 벽이 세워진 연구소에 바이러스를 퍼뜨린다.
    static void bfs() {
        for (int i = 0; i < settingMap.length; i++) {
            for (int j = 0; j < settingMap[i].length; j++) {
                testMap[i][j] = settingMap[i][j];
                if (testMap[i][j] == 2) {
                    q.offer(new Position(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Position current = q.poll();
            for (int i = 0; i < 4; i++) {
                Position next = new Position(current.n + moveN[i], current.m + moveM[i]);
                if (next.n >= 0 && next.n < testMap.length && next.m >= 0 && next.m < testMap[next.n].length) {
                    if (testMap[next.n][next.m] == 0) {
                        testMap[next.n][next.m] = 2;
                        q.offer(next);
                    }
                }
            }
        }
    }

    // 바이러스에서 살아남은 영역을 계산하고 큰 값으로 갱신한다.
    static void getAnswer() {
        int currentAnswer = 0;
        for (int i = 0; i < testMap.length; i++) {
            for (int j = 0; j < testMap[i].length; j++) {
                if (testMap[i][j] == 0) {
                    currentAnswer++;
                }
            }
        }

        if (answer < currentAnswer) {
            answer = currentAnswer;
        }
    }
}

class Position {
    int n;
    int m;

    public Position() {

    }

    public Position(int n, int m) {
        this.n = n;
        this.m = m;
    }
}