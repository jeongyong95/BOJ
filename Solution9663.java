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
public class Solution9663 {
    static int count = 0;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        board = new int[n];
        bufferedReader.close();

        backTracking(board, n, 0);
        bufferedWriter.write(count + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static void backTracking(int[] board, int n, int index) {
        if (index == n) {
            count++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[index] = i;
            if (isPossibleLocation(board, index)) {
                backTracking(board, n, index + 1);
            }
        }
        return;
    }

    static boolean isPossibleLocation(int[] board, int index) {
        for (int i = 0; i < index; i++) {
            if (board[index] == board[i] || index - i == Math.abs(board[index] - board[i])) {
                return false;
            }
        }
        return true;
    }
}