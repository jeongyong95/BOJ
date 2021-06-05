package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Solution10757 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);
        br.close();

        bw.write(a.add(b) + "\n");
        bw.flush();
        bw.close();
    }
}