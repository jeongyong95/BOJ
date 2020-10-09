import java.util.Scanner;

public class Solution11718 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            sb.append(input + "\n");
        }
        sc.close();
        System.out.println(sb);
    }
}