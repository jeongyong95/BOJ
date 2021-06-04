package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*  상근날드
    상근날드에서 가장 잘 팔리는 메뉴는 세트 메뉴이다. 주문할 때 자신이 원하는 햄버거와 음료를 하나씩 골라 세트로 구매하면, 
    가격의 합계에서 50원을 뺀 가격이 세트 메뉴의 가격이 된다.
    햄버거는 총 3종류 상덕버거, 중덕버거, 하덕버거가 있고, 음료는 콜라와 사이다 두 종류가 있다.
    햄버거와 음료의 가격이 주어졌을 때, 가장 싼 세트 메뉴의 가격을 출력하는 프로그램을 작성하시오.
    입력은 총 다섯 줄이다. 첫째 줄에는 상덕버거, 둘째 줄에는 중덕버거, 셋째 줄에는 하덕버거의 가격이 주어진다.
    넷째 줄에는 콜라의 가격, 다섯째 줄에는 사이다의 가격이 주어진다. 모든 가격은 100원 이상, 2000원 이하이다.
    첫째 줄에 가장 싼 세트 메뉴의 가격을 출력한다.
 */
public class Solution5534 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int high = Integer.parseInt(bufferedReader.readLine());
        int middle = Integer.parseInt(bufferedReader.readLine());
        int low = Integer.parseInt(bufferedReader.readLine());
        int cola = Integer.parseInt(bufferedReader.readLine());
        int sprite = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        int cheapBugger = high > middle ? (middle > low ? low : middle) : (high > low ? low : high);
        int carbonatedDrink = cola > sprite ? sprite : cola;

        int result = cheapBugger + carbonatedDrink - 50;

        bufferedWriter.write(result + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}