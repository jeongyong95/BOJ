import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Solution15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Set<String> resultSet = new TreeSet<>();
    static boolean[] checkArr;
    static int[] candidateArr;
    static int[] resultArr;

    public static void main(String[] args) throws IOException {

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        candidateArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        Arrays.sort(candidateArr);
        resultArr = new int[nm[1]];
        checkArr = new boolean[nm[0]];
        doRecursive(0, nm[0], nm[1]);
        for (String i : resultSet) {
            bw.write(i);
        }
        bw.flush();
        bw.close();
    }

    public static void doRecursive(int index, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : resultArr) {
                sb.append(i + " ");
            }
            sb.trimToSize();
            sb.append("\n");
            resultSet.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checkArr[i]) {
                continue;
            }
            resultArr[index] = candidateArr[i];
            checkArr[i] = true;
            doRecursive(index + 1, n, m);
            checkArr[i] = false;
        }
    }
}