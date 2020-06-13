package problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

/*  스도쿠
    스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다.
    이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 
    게임 시작 전 몇 몇 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.
    나머지 빈 칸을 채우는 방식은 다음과 같다.

    각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
    굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
    위의 예의 경우, 첫째 줄에는 1을 제외한 나머지 2부터 9까지의 숫자들이 이미 나타나 있으므로 첫째 줄 빈칸에는 1이 들어가야 한다.
    또한 위쪽 가운데 위치한 3x3 정사각형의 경우에는 3을 제외한 나머지 숫자들이 이미 쓰여있으므로 가운데 빈 칸에는 3이 들어가야 한다.
    이와 같이 빈 칸을 차례로 채워 가면 다음과 같은 최종 결과를 얻을 수 있다.
    게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.

    아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다.
    스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.
    모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.
    스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
 */
public class Solution2508 {
    static HashSet<Integer> numberSet = new HashSet<>();
    static int zeroChecker;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // index : 0~8
        int[][] sudoku = new int[9][9];

        // 주어진 값 채우기
        for (int i = 0; i < sudoku.length; i++) {
            String[] inputLine = bufferedReader.readLine().split(" ");
            for (int j = 0; j < sudoku[i].length; j++) {
                sudoku[i][j] = Integer.parseInt(inputLine[j]);
                if (sudoku[i][j] == 0) {
                    zeroChecker++;
                }
            }
        }
        bufferedWriter.write("--------------------\n");

        while (zeroChecker > 0) {
            backTracking(sudoku);
        }

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                bufferedWriter.write(sudoku[i][j] + " ");
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static void backTracking(int[][] sudoku) {

        // if (zeroChecker == 0) {
        // return;
        // }

        for (int i = 0; i < sudoku.length; i++) {
            int zeroCounter = 0, zeroIndex = 0;

            for (int number : sudoku[i]) {
                numberSet.add(number);
            }

            for (int j = 0; j < sudoku[i].length; j++) {
                if (sudoku[i][j] == 0) {
                    zeroIndex = j;
                    zeroCounter++;
                    if (zeroCounter > 1) {
                        break;
                    }
                }
            }

            if (zeroCounter == 1) {
                for (int j = 1; j <= 9; j++) {
                    if (!numberSet.contains(j)) {
                        sudoku[i][zeroIndex] = j;
                        zeroChecker--;
                        break;
                    }
                }
            }
            numberSet.clear();
        }
        for (int i = 0; i < sudoku[0].length; i++) {
            int zeroCounter = 0, zeroIndex = 0;

            for (int j = 0; j < sudoku.length; j++) {
                numberSet.add(sudoku[j][i]);
            }

            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[j][i] == 0) {
                    zeroIndex = j;
                    zeroCounter++;
                    if (zeroCounter > 1) {
                        break;
                    }
                }
            }

            if (zeroCounter == 1) {
                for (int j = 1; j <= 9; j++) {
                    if (!numberSet.contains(j)) {
                        sudoku[zeroIndex][i] = j;
                        zeroChecker--;
                        break;
                    }
                }
            }
            numberSet.clear();
        }
        // backTracking(sudoku);
        return;
    }
}