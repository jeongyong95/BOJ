package boj.dataStructure.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1717 {
    static int[] link;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        link = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            link[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operation == 0) {
                unite(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void unite(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            link[b] = a;
        } else if (a > b) {
            link[a] = b;
        }
    }

    static int find(int x) {
        // while (x != link[x]) {
        // x = link[x];
        // }
        // return x;

        // 경로 압축
        if (x == link[x]) {
            return x;
        }
        return link[x] = find(link[x]);
    }
}