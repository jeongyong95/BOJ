import java.io.IOException;

/**
 * test
 */
public class test {

    public static void main(String[] args) throws IOException {

    }

    // BufferedReader 와 BufferedWriter를 사용하려면

    // 1. import java.io.*; 선언
    // 2. throws IOException 으로 사용하는 메소드에 예외처리를 위임해라 ( try ~ catch로 해도 되지만.. )
    // 3. readLine() 은 String만 리턴한다. 다른 자료형으로 활용하려면 형변환해라.
    // 4. reader도 writer도 사용후엔 스트림을 닫아주자.
    // writer는 닫기전에 flush를 활용해 남아있는 데이터를 모두 출력시켜야한다.
    // 5. 개행처리는 +"\n"을 활용하는 걸 추천한다. newLine() 을 활용할 수도 있지만 개행문자와 비교하면 속도가 느리고
    // 다른 자료형을 출력할 땐 String으로 형변환도 해주니
    // int를 출력했는데 아스키 코드 숫자에 해당하는 문자가 출력되는 일을 막아줄 수도 있다.
}