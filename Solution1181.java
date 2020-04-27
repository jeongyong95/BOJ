import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/*  단어 정렬
    알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
    길이가 짧은 것부터, 길이가 같으면 사전 순으로
    첫째 줄에 단어의 개수 N이 주어진다.
    (1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
    주어지는 문자열의 길이는 50을 넘지 않는다.
    조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 */
public class Solution1181 {
    // compareTo 이해가 필요하다.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[n];

        for (int i = 0; i < words.length; i++) {
            words[i] = bufferedReader.readLine();
        }
        bufferedReader.close();
        Arrays.sort(words, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    if (o1.compareTo(o2) > 0) {
                        return 1;
                    }
                    if (o1.compareTo(o2) == 0) {
                        return 0;
                    }
                    return -1;
                }
                if (o1.length() < o2.length()) {
                    return -1;
                }
                return 1;
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (i > 0 && words[i].equals(words[i - 1])) {
                continue;
            }
            bufferedWriter.write(words[i] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}