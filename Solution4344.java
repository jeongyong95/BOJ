import java.util.Scanner;

/*  평균은 넘겠지
    대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
    첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
    둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
    점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
    각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 */
public class Solution4344 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int jumper = 0;
        int[][] caseArray = new int[testCase][];
        double[] average = new double[testCase];

        for (int i = 0; i < testCase; i++) {
            int setCase = scanner.nextInt();
            int sum = 0;
            caseArray[i] = new int[setCase];
            for (int j = 0; j < caseArray[i].length; j++) {
                caseArray[i][j] = scanner.nextInt();
                sum += caseArray[i][j];
                if (j == caseArray[i].length - 1) {
                    average[i] = sum / caseArray[i].length;
                }
            }
        }

        for (int i = 0; i < caseArray.length; i++) {
            for (int j = 0; j < caseArray[i].length; j++) {
                if (caseArray[i][j] > average[i]) {
                    jumper++;
                }
            }
            System.out.println(jumper / caseArray[i].length);
            jumper = 0;
        }

        scanner.close();
    }
}