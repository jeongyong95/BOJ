package boj.bruteForce.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  N-Queen
    N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
    N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
    첫째 줄에 N이 주어진다. (1 ≤ N < 15)
    첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 */
public class Solution9663_2 {
    static int[] board;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();
        board = new int[n];

        dfs(board, n, 0);

        bufferedWriter.write(count + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static void dfs(int[] board, int n, int index) {
        if (index == n) {
            count++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            board[index] = i;
            if (checker(board, index)) {
                dfs(board, n, index + 1);
            }
            board[index] = 0;
        }
        return;
    }

    static boolean checker(int[] board, int index) {
        for (int i = 0; i < index; i++) {
            // 서로 동일한 행이거나 서로 대각선에 위치해있으면 board[index]에는 퀸이 올 수 없다.
            if (board[i] == board[index] || index - i == Math.abs(board[index] - board[i])) {
                return false;
            }
        }
        return true;
    }
}