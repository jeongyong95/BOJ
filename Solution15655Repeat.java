import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution15655Repeat {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] checkArr = new boolean[10001];
    static int[] candidateArr;
    static int[] resultArr;

    public static void main(String[] args) throws IOException {
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        candidateArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        Arrays.sort(candidateArr);
        resultArr = new int[nm[1]];
        doRecursive(0, nm[1]);
        bw.flush();
        bw.close();
    }

    public static void doRecursive(int index, int m) throws IOException {
        if (index == m) {
            for (int i : resultArr) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < candidateArr.length; i++) {
            if (checkArr[candidateArr[i]] || (index > 0 && resultArr[index - 1] > candidateArr[i])) {
                continue;
            }

            checkArr[candidateArr[i]] = true;
            resultArr[index] = candidateArr[i];
            doRecursive(index + 1, m);
            checkArr[candidateArr[i]] = false;
        }
    }
}