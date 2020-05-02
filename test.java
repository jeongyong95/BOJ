import java.util.Arrays;

/**
 * test & setting
 */
public class test {
    public static void main(String[] args) {
        int[] num = new int[100];
        for (int i = 0; i < num.length; i++) {
            num[i] = i * 3;
        }

        int sum = Arrays.stream(num).filter(n -> (n % 2 == 1)).sum();
        System.out.println(sum);
    }
}