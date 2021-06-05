package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*  나이순 정렬
    온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
    이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
    첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
    둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
    나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 
    길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.
    첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 
    나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
 */
public class Solution10814 {
    // Arrays.sort 이용
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] line;
        User[] users = new User[n];
        for (int i = 0; i < users.length; i++) {
            line = bufferedReader.readLine().split(" ");
            User user = new User(Integer.parseInt(line[0]), line[1], i);
            users[i] = user;
        }
        bufferedReader.close();
        Arrays.sort(users);

        for (int i = 0; i < users.length; i++) {
            bufferedWriter.write(users[i].age + " " + users[i].name + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static class User implements Comparable<User> {
        String name;
        int age;
        int joinSeq;

        User(int age, String name, int joinSeq) {
            this.name = name;
            this.age = age;
            this.joinSeq = joinSeq;
        }

        @Override
        public int compareTo(User o) {
            if (this.age == o.age) {
                return Integer.compare(this.joinSeq, o.joinSeq);
            }
            return Integer.compare(this.age, o.age);
        }
    }
}