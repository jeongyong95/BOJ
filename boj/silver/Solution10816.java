package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution10816 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int input = Integer.parseInt(st.nextToken());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(target, 0) + " ");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
