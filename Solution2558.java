import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solution2558
 */
public class Solution2558 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer a = Integer.parseInt(bufferedReader.readLine());
        Integer b = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        System.out.println(a + b);
    }
}